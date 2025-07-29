import java.util.Scanner;

public class Main {

    public static int[][] grid;
    public static int n, m, k;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        int targetRow = 0;
        while (canShift(targetRow + 1)) {
            targetRow++;
        }

        for(int c = k; c <= k + m; c++) {
            grid[targetRow][c] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // k = 0, m = 3, k + m = 3;
    public static boolean canShift(int row) {
        if (row >= n) {
            return false;
        }

        for(int c = k; c <= k + m; c++) {
            if (grid[row][c] == 1) return false;
        }

        return true;
    }

    public static void input() {
        n = sc.nextInt();
        m = sc.nextInt() - 1;
        k = sc.nextInt() - 1;
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}