import java.util.Scanner;

public class Main {

    public static int[][] grid;
    public static int[][] temp;

    public static int[] dx = {0, -1, 0, 1, 0};
    public static int[] dy = {0, 0, 1, 0, -1};

    public static int n, m, q;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        for (int i = 0; i < q; i++) {
            int r1 = sc.nextInt() - 1;
            int c1 = sc.nextInt() - 1;
            int r2 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;

            shift(r1, c1, r2, c2);
        }

        printArr();
    }

    public static void shift(int r1, int c1, int r2, int c2) {
        int temp1 = grid[r1][c2];
        int temp2 = grid[r2][c2];
        int temp3 = grid[r2][c1];
        int temp4 = grid[r1][c1];

        // 맨 위 이동
        for (int i = c2; i > c1 + 1; i--) {
            grid[r1][i] = grid[r1][i - 1];
        }

        // 오른쪽 이동
        for (int i = r2; i > r1 + 1; i--) {
            grid[i][c2] = grid[i - 1][c2];
        }

        // 아래쪽 이동
        for (int i = c1; i < c2 - 1; i++) {
            grid[r2][i] = grid[r2][i + 1];
        }

        // 왼쪽 이동
        for (int i = r1; i < r2 - 1; i++) {
            grid[i][c1] = grid[i + 1][c1];
        }

        grid[r1 + 1][c2] = temp1;
        grid[r2][c2 - 1] = temp2;
        grid[r2 - 1][c1] = temp3;
        grid[r1][c1 + 1] = temp4;

        changeValue(r1, c1, r2, c2);
    }

    public static void changeValue(int r1, int c1, int r2, int c2) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int cnt = 0;
                int sum = 0;

                for (int k = 0; k < 5; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (inRange(x, y)) {
                        cnt++;
                        sum += grid[x][y];
                    }
                }

                temp[i][j] = sum / cnt;
            }
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                grid[i][j] = temp[i][j];
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static void printArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        grid = new int[n][m];
        temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}