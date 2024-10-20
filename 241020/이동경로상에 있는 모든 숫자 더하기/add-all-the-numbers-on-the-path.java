import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String command = sc.next();
        int[][] arr = new int[n][n];
        // 상 우 하 좌
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int dir = 0;
        int x = n / 2;
        int y = n / 2;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int sum = arr[y][x];

        for(int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            if(c == 'R') {
                dir++;
                if(dir == 4) {
                    dir = 0;
                }
            } else if(c == 'L') {
                dir--;
                if(dir == -1) {
                    dir = 3;
                }
            } else {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(inRange(nx, ny, n)) {
                    sum += arr[ny][nx];
                    x = nx;
                    y = ny;
                }
            }
        }

        System.out.println(sum);
    }

    public static boolean inRange(int x, int y, int n) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }
}