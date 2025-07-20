import java.util.Scanner;

public class Main {

    public static int n;
    public static int[][] grid;

    public static int[] dx = {-1, -1, 1, 1};
    public static int[] dy = {1, -1, -1, 1};

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }

    public static void solve() {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int width = 1; width <= n; width++) {
                    for (int height = 1; height <= n; height++) {
                        answer = Math.max(answer, count(i, j, width, height));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static int count(int row, int col, int width, int height) {
        int[] lengths = {width, height, width, height};
        int x = row;
        int y = col;
        int sum = 0;

        for(int dir = 0; dir < 4; dir++) {
            int length = lengths[dir];

            for(int i = 0; i < length; i++) {
                x += dx[dir];
                y += dy[dir];

                if (!inRange(x , y)) return 0;
                sum += grid[x][y];
            }
        }

        return sum;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}