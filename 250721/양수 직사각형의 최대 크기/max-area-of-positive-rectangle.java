import java.util.Scanner;

public class Main {

    public static int n, m;
    public static int[][] grid;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        int ans = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = i; k < n; k++) {
                    for(int l = j; l < n; l++) {
                        if (isPositiveSquare(i, j, k, l)) {
                            ans = Math.max(ans, (k - i + 1) * (l - j + 1));
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }

    public static boolean isPositiveSquare(int i, int j, int k, int l) {
        for(int r = i; r <= k; r++) {
            for(int c = j; c <= l; c++) {
                if (grid[r][c] <= 0) return false;
            }
        }

        return true;
    }
}