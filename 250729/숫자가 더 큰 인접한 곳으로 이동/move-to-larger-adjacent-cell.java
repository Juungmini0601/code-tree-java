import java.util.Scanner;

public class Main {

    public static int[][] grid;
    public static int n, r, c;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        StringBuilder sb = new StringBuilder();
        sb.append(grid[r][c]).append(" ");
        boolean run = false;

        do {
            run = false;
            // 현재 위치에서 상 하 좌 우 방향 순서대로 큰 숫자가 있으면 그쪽으로 이동한다.
            for(int dir = 0; dir < 4; dir++) {
                int nextX = r + dx[dir];
                int nextY = c + dy[dir];

                if(inRange(nextX, nextY) && grid[nextX][nextY] > grid[r][c]) {
                    r = nextX;
                    c = nextY;
                    sb.append(grid[r][c]).append(" ");
                    run = true;
                    break;
                }
            }
        } while (run);

        System.out.println(sb);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void input() {
        n = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}