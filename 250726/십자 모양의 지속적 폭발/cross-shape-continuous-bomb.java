import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // 제자리 상 우 하 좌
    public static int[] dx = {-1 ,0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int[][] grid;
    public static int n, m;
    public static final int EMPTY = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        for(int i = 0; i < m; i++) {
            int col = sc.nextInt()-1;
            int row = find(col);

            if (row == -1) continue;

            bomb(row, col);
        }

        printGrid();
    }

    private static void printGrid() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bomb(int row, int col) {
        int distance = grid[row][col]-1;
        grid[row][col] = EMPTY;

        for(int dir = 0; dir < 4; dir++) {
            for(int i = 1; i <= distance; i++) {
                int x = row + dx[dir] * i;
                int y = col + dy[dir] * i;

                if (inRange(x, y)) {
                    grid[x][y] = EMPTY;
                }
            }
        }

        int[][] temp = new int[n][n];

        for(int c = 0; c < n; c++) {
            int tempR = n-1;

            for(int r = n-1; r >= 0; r--) {
                if (grid[r][c] != EMPTY) {
                    temp[tempR][c] = grid[r][c];
                    tempR--;
                }
            }
        }

        grid = temp;
    }

    public static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static int find(int col) {
        for(int row = 0; row < n; row++) {
            if (grid[row][col] != EMPTY) return row;
        }

        return -1;
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
}
