import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 상 우 하 좌
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int oneCnt = 0;

                for(int dir = 0; dir < 4; dir++) {
                    int nextX = j + dx[dir];
                    int nextY = i + dy[dir];

                    if(inRange(nextX, nextY, n) && arr[nextY][nextX] == 1) {
                        oneCnt++;
                    }
                }

                if(oneCnt >= 3) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean inRange(int x, int y, int n) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }
}