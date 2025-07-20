import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 마름모의 최대는 2 * N
// 금 한개의 가격이 M일 때 손해를 보지 않으면서 채굴 할 수 있는 가장 많은 금의 수
public class Main {

    public static int n, m;
    public static int[][] distance;
    public static int[][] grid;
    // 상 우 하 좌
    public static int[] dx = {-1 ,0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }

    public static void solve() {
        int maxCost = 0;
        int maxLength = 2 * n;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k <= maxLength; k++) {
                    maxCost = Math.max(maxCost, BFS(i, j, k));
                }
            }
        }

        System.out.println(maxCost);
    }

    public static int BFS(int row, int col, int length) {
        int cost = 0;
        distance = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        distance[row][col] = 1;
        q.add(new int[]{row, col});

        if (grid[row][col] == 1) {
            cost += m;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            // 현재 위치가 갈 수 있는 최대 지점인 경우 패스
            if (distance[x][y] == length + 1) continue;

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (!inRange(nx, ny)) continue;
                if (distance[nx][ny] != 0) continue;
                // nx, ny는 방문 한 적이 없는 지점
                distance[nx][ny] = distance[x][y] + 1;
                if (grid[nx][ny] == 1) {
                    cost += m;
                }

                q.add(new int[]{nx, ny});
            }
        }


        int goldCount = cost - ((length * length) + (length + 1) * (length + 1)) >= 0 ? cost / m : 0;
        return goldCount;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
