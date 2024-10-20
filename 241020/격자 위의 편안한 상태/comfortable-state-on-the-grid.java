import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 편안한 상태는 위아래양옆 3개가 색칠된 칸이어야한다.
        // 색칠할 칸이 주어질 때마다 해당 칸을 색칠한 후 편안한 상태에 있는지를 출력하시오.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        // 상 우 하 좌
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for(int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            arr[r][c] = 1;

            int coloredCnt = 0;

            for(int dir = 0; dir < 4; dir++) {
                int nx = c + dx[dir];
                int ny = r + dy[dir];

                if(!inRange(nx, ny, n)) {
                    continue;
                }

                if(arr[ny][nx] == 1) {
                    coloredCnt++;
                }
            }

            System.out.println(coloredCnt == 3 ? 1 : 0);
        }
    }

    public static boolean inRange(int x, int y, int n) {
        return (1 <= x && x <= n) && (1 <= y && y <= n);
    }
}