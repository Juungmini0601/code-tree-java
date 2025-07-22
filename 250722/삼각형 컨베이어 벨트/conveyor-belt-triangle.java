import java.util.Scanner;

public class Main {

    public static int n, t;
    public static int[][] grid;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        for (int i = 0; i < t; i++) {
            shift();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void shift() {
        int temp1 = grid[0][n-1];
        int temp2 = grid[1][n-1];
        int temp3 = grid[2][n-1];

        // 1층 이동
        for (int i = n-1; i >= 1; i--) {
            grid[0][i] = grid[0][i-1];
        }

        grid[0][0] = temp3;

        // 2층 이동
        for (int i = n-1; i >= 1; i--) {
            grid[1][i] = grid[1][i-1];
        }

        grid[1][0] = temp1;

        // 2층 이동
        for (int i = n-1; i >= 1; i--) {
            grid[2][i] = grid[2][i-1];
        }

        grid[2][0] = temp2;
    }

    public static void input() {
        n = sc.nextInt();
        t = sc.nextInt();

        grid = new int[3][n];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}