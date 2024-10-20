import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int x = 0;
        int y = 0;
        int dir = 0;
        // 하 우 상 좌
        int[] dx = {0, 1, 0 ,-1};
        int[] dy = {1, 0, -1, 0};

        arr[y][x] = 1;

        for(int i = 2; i <= n * m; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx, ny, n, m) || arr[ny][nx] != 0) {
                dir++;
                dir %= 4;
            }

            x = x + dx[dir];
            y = y + dy[dir];
            // System.out.println(String.format("[%d, %d]", y, x));
            arr[y][x] = i;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int x, int y, int n, int m) {
        return (0 <= x && x < m) && (0 <= y && y < n);
    }
}