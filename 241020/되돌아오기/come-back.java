import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        int y = 0;
        // 상 우 하 좌
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int time = 0;
        int ans = -1;

        for(int i = 0; i < n; i++) {
            String d = sc.next();
            int distance = sc.nextInt();
            int dir = dirToInt(d);
            
            for(int j = 0; j < distance; j++) {
                x = x + dx[dir];
                y = y + dy[dir];
                time++;

                if(x == 0 && y == 0) {
                    ans = time;
                    break;
                }
            }

            if(ans != -1) break;
        }

        System.out.println(ans);
    }

    public static int dirToInt(String dir) {
        if(dir.equals("N")) {
            return 0;
        } else if (dir.equals("E")) {
            return 1;
        } else if (dir.equals("S")) {
            return 2;
        } else {
            return 3;
        }
    }
}