import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans = Math.max(type1(i, j), ans);
                ans = Math.max(type2(i, j), ans);
                ans = Math.max(type3(i, j), ans);
                ans = Math.max(type4(i, j), ans);
                ans = Math.max(type5(i, j), ans);
                ans = Math.max(type6(i, j), ans);
            }
        }

        System.out.println(ans);
    }

    // ㄴ
    public static int type1(int row, int col) {
        if(row + 1 >= n || col + 1 >= m) {
            return 0;
        }

        return arr[row][col] + arr[row+1][col] + arr[row+1][col+1];
    }

    // ㄴ 반대 방향
    public static int type2(int row, int col) {
        if(row + 1 >= n || col - 1 < 0) {
            return 0;
        }

        return arr[row][col] + arr[row+1][col] + arr[row+1][col-1];
    }

    // ㄱ
    public static int type3(int row, int col) {
        if(row + 1 >= n || col + 1 >= m) {
            return 0;
        }

        return arr[row][col] + arr[row][col+1] + arr[row+1][col+1];
    }

    // ㄱ 반대 방향
    public static int type4(int row, int col) {
        if(row + 1 >= n || col + 1 >= m) {
            return 0;
        }

        return arr[row][col] + arr[row][col+1] + arr[row+1][col];
    }

    // ㅣ
    public static int type5(int row, int col) {
        if(row + 2 >= n) {
            return 0;
        }

        return arr[row][col] + arr[row+1][col] + arr[row+2][col];
    }

    // ㅡ
    public static int type6(int row, int col) {
        if(col + 2 >= m) {
            return 0;
        }

        // System.out.printf("%d %d %d\n", arr[row][col], arr[row][col+1], arr[row][col+2]);
        return arr[row][col] + arr[row][col + 1] + arr[row][col+2];
    }
}
