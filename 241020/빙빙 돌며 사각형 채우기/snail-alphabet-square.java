import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        int x = 0;
        int y = 0;
        int dir = 0;
        char cur = 'A';
        // 우 하 좌 상
        int[] dx = {1, 0, -1 ,0};
        int[] dy = {0, 1, 0, -1};

        arr[y][x] = cur;
        cur++;

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
            arr[y][x] = cur;
            cur++;
            if(cur > 'Z') {
                cur = 'A';
            }
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