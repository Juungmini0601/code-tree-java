import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cur = {0, 0};
        // 위 오른쪽 아래 왼쪽
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        int t = 0;
        int ans = -1;
        String command = sc.next();

        for(int i = 0; i < command.length(); i++) {
            t++;
            char c = command.charAt(i);

            switch(c) {
                case 'L':
                    dir--;
                    if(dir == -1) {
                        dir = 3;
                    }
                    break;
                case 'R':
                    dir++;
                    if(dir == 4) {
                        dir = 0;
                    }
                    break;
                case 'F':
                    cur[0] += dx[dir];
                    cur[1] += dy[dir];
                    break;
            }

            if(cur[0] == 0 && cur[1] == 0) {
                ans = t;
                break;
            }
        }
        System.out.println(ans);
    }
}