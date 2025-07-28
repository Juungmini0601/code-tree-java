import java.util.Scanner;

public class Main {

    public static int[][] grid;
    public static int n;
    public static final int EMPTY = 0;

    public static int[] dx = {0, -1, 0, 1, 0};
    public static int[] dy = {0, 0, 1, 0, -1};

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(bombAndCount(i, j), ans);
            }
        }

        System.out.println(ans);
    }

    public static int bombAndCount(int x, int y) {
        int[][] copy = copy();
        int distance = copy[x][y] - 1;

        for (int i = 1; i <= distance; i++) {
            for (int dir = 0; dir < 5; dir++) {
                int tempX = x + dx[dir] * i;
                int tempY = y + dy[dir] * i;

                if (inRange(tempX, tempY)) {
                    copy[tempX][tempY] = EMPTY;
                }
            }
        }

        copy = shift(copy);

        return count(copy);
    }

    public static int count(int[][] arr) {
        int count = 0;
        // 세로로 세기
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != EMPTY && arr[i][j] == arr[i + 1][j]) {
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] != EMPTY && arr[i][j] == arr[i][j + 1]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static int[][] shift(int[][] arr) {
        int[][] temp = new int[n][n];

        for (int c = 0; c < n; c++) {
            int tempRowIndex = n - 1;

            for (int r = n - 1; r >= 0; r--) {
                if (arr[r][c] != EMPTY) {
                    temp[tempRowIndex][c] = arr[r][c];
                    tempRowIndex--;
                }
            }
        }

        return temp;
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

    public static int[][] copy() {
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        return copy;
    }
}