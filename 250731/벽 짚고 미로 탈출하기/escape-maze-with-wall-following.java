import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// N * N 크기의 격자 우측 방향을 바라고보 시작
// 벽을 짚고 따라간다 바라 보고 있는 방향으로 이동이 불가능하다면 반시계 방향으로 회전한다.
// 바라보고 있는 방향으로 이동 하는 것이 가능한 경우 격자 밖이라면 탈출한다.
// 만약 그 방향으로 이동한다 했을때 오른쪽에 짚을 벽이 있다면 그 방향으로 한 칸 이동한다.
// 만약 그 방향으로 이동했다 했을때 우측에 벽이 없다면 방향을 시계방향으로 틀어 한칸 더 전진한다.
public class Main {

    public static boolean [][][]visited;
    public static int[][] grid;
    public static int n, x, y, d;
    public static Map<Integer, String> directions;
    public static Scanner sc = new Scanner(System.in);

    // 우 상 하 좌 이동에 사용되는 좌표
    public static int[] dx ={0, -1, 0, 1};
    public static int[] dy ={1, 0, -1, 0};

    // 우, 상, 좌, 하의 오른쪽 벽을 찾는데 사용되는 좌표
    public static int[] rx = {1, 0, -1, 0};
    public static int[] ry = {0, 1, 0, -1};

    public static void main(String[] args) {
        init();
        visited[d][x][y] = true;
        int move = 0;

        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 현재 방향으로 전진 시켰을 때 좌표가 격자 밖이라면 탈출한다.
            if (!inRange(nx, ny)) {
                move++;
                System.out.println(move);
                return;
            }

            // 현재 바라보고 있는 방향으로 이동이 불가능하다면
            if (grid[nx][ny] == 1) {
                d = rotateLeft(d);
                continue;
            }
            // 현재 바라보고 있는 방향으로 이동이 가능하다면 먼저 이전에 같은 방향으로 같은 좌표에 온적이 있는지 확인
            if (visited[d][nx][ny]) {
                System.out.println(-1);
                return;
            }
            // 같은 방향으로 같은 좌표에 온 적이 없다면 이동
            x = nx;
            y = ny;
            visited[d][x][y] = true;
            move++;
            // 현재 좌표에서 방향의 오른쪽에 벽이 있는지 확인 해서 없다면 오른쪽으로 회전 후 이동
            if (grid[x + rx[d]][y + ry[d]] != 1) {
                d = rotateRight(d);
                visited[d][x][y] = true;
                x += dx[d];
                y += dy[d];
                move++;
                visited[d][x][y] = true;
            }
        }
    }

    public static boolean canMove(int x, int y, int direction) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];

        return inRange(nx, ny) && grid[nx][ny] == 0;
    }

    public static int rotateLeft(int direction) {
        return (direction + 1) >= 4 ? 0 : (direction + 1);
    }

    public static int rotateRight(int direction) {
        return (direction - 1) < 0 ? 3 : (direction - 1);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void init() {
        directions = new HashMap<>();
        n = sc.nextInt();
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;
        sc.nextLine();
        d = 0;

        grid = new int[n][n];
        visited = new boolean[4][n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();

            for(int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j) == '#' ? 1 : 0;
            }
        }

        directions.put(0, "R");
        directions.put(1, "U");
        directions.put(2, "L");
        directions.put(3, "D");
    }
}