import java.util.Scanner;

public class Main {

    public static int[][] temp;
    public static int[][] grid;
    public static int n, m, q;

    public static int[] dx = {0, -1, 0, 1, 0};
    public static int[] dy = {0, 0, 1, 0, -1};

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        for (int i = 0; i < q; i++) {
            int r1, r2, c1, c2;
            r1 = sc.nextInt();
            c1 = sc.nextInt();
            r2 = sc.nextInt();
            c2 = sc.nextInt();

            shift(r1, c1, r2, c2);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(grid[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void shift(int startRow, int startCol, int endRow, int endCol) {
        // 상단 경계를 오른쪽으로 이동
        int temp1 = grid[startRow][endCol];
        for (int i = endCol; i >= startCol + 1; i--) {
            grid[startRow][i] = grid[startRow][i - 1];
        }
        // 우측 경계를 아래쪽으로 이동
        int temp2 = grid[endRow][endCol];
        for (int i = endRow; i >= startRow + 1; i--) {
            grid[i][endCol] = grid[i - 1][endCol];
        }
        // 하단 경계를 왼쪽으로 이동
        int temp3 = grid[endRow][startCol];
        for(int i = startCol; i <= endCol - 1; i++) {
            grid[endRow][i] = grid[endRow][i + 1];
        }
        // 좌측 경계를 위쪽으로 이동
        int temp4 = grid[startRow][startCol];
        for(int i = startRow; i <= endRow - 1; i++) {
            grid[i][startCol] = grid[i + 1][startCol];
        }

        grid[startRow + 1][endCol] = temp1;
        grid[endRow][endCol-1] = temp2;
        grid[endRow-1][startCol] = temp3;
        grid[startRow][startCol+1] = temp4;

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                int cnt = 0;
                int sum = 0;

                for (int k = 0; k < 5; k++) {
                    if (inRange(i + dx[k], j + dy[k])) {
                        sum += grid[i + dx[k]][j + dy[k]];
                        cnt++;
                    }
                }

                temp[i][j] = sum / cnt;
            }
        }

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                grid[i][j] = temp[i][j];
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 1 && r <= n && c >= 1 && c <= m;
    }

    public static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        grid = new int[n + 1][m + 1];
        temp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}