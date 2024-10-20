import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int cur = n * n;
        // 좌 상 우 하
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int dir = 0;
        int x = n-1;
        int y = n-1;
        arr[n-1][n-1] = cur;
        for(int i = 2; i <= n * n; i++) {
            cur--;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx, ny, n) || arr[ny][nx] != 0) {
                dir++;
                dir %= 4;
            }

            x = x + dx[dir];
            y = y + dy[dir];
            // System.out.println(String.format("[%d, %d]", y, x));
            arr[y][x] = cur;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int x, int y, int n) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }
}