import java.util.Scanner;

public class Main {

    public static int[][] grid;
    public static int n, r, c;
    public static final int EMPTY = 0;
    // 상 우 하 좌
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        bomb();
        shift();
        print();
    }

    public static void print() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void shift() {
        int[][] temp = new int[n][n];

        for(int col = 0; col < n; col++) {
            int tempIndex = n - 1;
            for(int row = n-1; row >= 0; row--) {
                if (grid[row][col] != EMPTY) {
                    temp[tempIndex][col] = grid[row][col];
                    tempIndex--;
                }
            }
        }

        grid = temp;
    }

    public static void bomb() {
        int distance = grid[r][c] - 1;
        grid[r][c] = EMPTY;
        // 폭탄을 십자 모양으로 터트림
        for(int dir = 0; dir < 4; dir++) {
            for(int i = 1; i <= distance; i++) {
                int x = r + dx[dir] * i;
                int y = c + dy[dir] * i;

                if(inRange(x, y)) {
                    grid[x][y] = EMPTY;
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void input() {
        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        r = sc.nextInt()-1;
        c = sc.nextInt()-1;
    }
}