import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        // 우 하 왼 상
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int dir = 0;
        arr[y][x] = 1;

        for(int i = 2; i <= n * m; i++) {
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if(inRange(nextX, nextY, n, m) && arr[nextY][nextX] == 0) {
                x = nextX;
                y = nextY;
                arr[y][x] = i;
            } else {
                dir = (dir + 1) % 4;
                nextX = x + dx[dir];
                nextY = y + dy[dir];
                x = nextX;
                y = nextY;
                arr[y][x] = i;
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