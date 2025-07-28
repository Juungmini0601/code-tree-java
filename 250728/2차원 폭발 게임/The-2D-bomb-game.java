import java.util.Scanner;

// 각 열에 대해 M개 이상의 같은 숫자가 적혀 있는 폭탄은 터지고 아래로 내려옴
// 터진 이후에도 같은 열에 M개 이상의 폭탄이 있다면 계속 터트릴 거임
// 터진 이후에는 상자를 시계 방향으로 이동 시킬거고 중력의 영향을 받음
// 터지고 회전하는 과정을 K번 반복 했을 때 최종적으로 상자에 남아 있는 폭탄의 수를 출력하시오
public class Main {

    public static int[][] grid;
    public static int n, m, k;
    public static final int EMPTY = 0;
    public static final int MARK = -1;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        for(int i = 0; i < k; i++) {
            while (bomb()) {
                shift();
            }

            rotate();
            shift();

            while (bomb()) {
                shift();
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] != EMPTY) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }

    public static void printGrid() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.println();
        }
    }

    // 시계 방향으로 이동
    public static void rotate() {
        int[][] temp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[i][j] = grid[n-1-j][i];
            }
        }

        grid = temp;
    }

    public static boolean bomb() {
        int bomCount = 0;

        for(int c = 0; c < n; c++) {
            if (mark(c)) {
                bomCount++;
            }
        }

        return bomCount > 0;
    }

    // 해당 열에 동일한 숫자가 M개 이상 연속으로 있으면 마킹
    public static boolean mark(int col) {
        int beforeIndex = 0;
        int count = grid[beforeIndex][col] == EMPTY ? 0 : 1;
        boolean result = false;

        for(int r = 1; r < n; r++) {
            if (grid[r][col] == EMPTY) {
                grid[beforeIndex][col] = EMPTY;
                count = 0;
                continue;
            }

            // 현재 원소가 비어 있지 않은데 이전 원소가 비어 있는 경우
            if (grid[r-1][col] == EMPTY) {
                beforeIndex = r;
                count = 1;
            }
            // 이전 원소가 비어 있지 않으면서 같은 경우
            else if (grid[r][col] == grid[r-1][col]) {
                count++;
            }
            // 이전 원소가 비어 있지 않으면서 다른 경우
            else {
                if (count >= m) {
                    result = true;
                    mark(beforeIndex, r-1, col);
                }
                beforeIndex = r;
                count = 1;
            }
        }

        if (count >= m) {
            result = true;
            mark(beforeIndex, n-1, col);
        }

        return result;
    }

    public static void mark(int startRow, int endRow, int col) {
        for(int r = startRow; r <= endRow; r++) {
            grid[r][col] = MARK;
        }
    }

    public static void shift() {
        int[][] temp = new int[n][n];

        for(int c = 0; c < n; c++) {
            int tempRowIndex = n - 1;

            for(int r = n-1; r >= 0; r--) {
                if (grid[r][c] != MARK && grid[r][c] != EMPTY) {
                    temp[tempRowIndex][c] = grid[r][c];
                    tempRowIndex--;
                }
            }
        }

        grid = temp;
    }
}