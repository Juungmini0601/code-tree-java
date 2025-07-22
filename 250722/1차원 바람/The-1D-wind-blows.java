import java.util.Scanner;

public class Main {

    public static int n, m, q, r;
    public static String d;
    public static int[][] grid;


    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        for (int i = 0; i < q; i++) {
            r = sc.nextInt();
            d = sc.next();
            r = r-1;

            shift(r, d);
            String nextDir = d.equals("L") ? "R" : "L";

            if (canShift(r, r - 1)) {
                moveToTop(r - 1, nextDir);
            }

            if (canShift(r, r + 1)) {
                moveToBottom(r + 1, nextDir);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void moveToTop(int row, String d) {
        if (row < 0) {
            return;
        }

        shift(row, d);

        if (canShift(row, row - 1)) {
            String nextDir = d.equals("L") ? "R" : "L";
            moveToTop(row - 1, nextDir);
        }
    }

    public static void moveToBottom(int row, String d) {
        if (row >= n) {
            return;
        }

        shift(row, d);

        if (canShift(row, row + 1)) {
            String nextDir = d.equals("L") ? "R" : "L";
            moveToBottom(row + 1, nextDir);
        }
    }

    public static void shift(int row, String d) {
        // 바람이 왼쪽에서 불면 오른쪽으로 한 칸 이동
        if (d.equals("L")) {
            int temp = grid[row][m - 1];
            for (int i = m - 1; i >= 1; i--) {
                grid[row][i] = grid[row][i - 1];
            }
            grid[row][0] = temp;
            return;
        }

        // 바람이 오른쪽에서 불면 왼쪽으로 한 칸 이동
        int temp = grid[row][0];
        for (int i = 0; i < m - 1; i++) {
            grid[row][i] = grid[row][i + 1];
        }
        grid[row][m - 1] = temp;
    }

    public static boolean canShift(int row1, int row2) {
        if (row1 >= n || row2 >= n) return false;
        if (row1 < 0 || row2 < 0) return false;

        for (int i = 0; i < m; i++) {
            if (grid[row1][i] == grid[row2][i]) {
                return true;
            }
        }

        return false;
    }

    public static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

    }
}