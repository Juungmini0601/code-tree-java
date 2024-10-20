import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Case1 /거울 상우하좌 좌표값 달라짐
        // Case2 \거울 상우하좌 좌표값 달라짐 ㅇㅋ?
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            arr[i] = s.toCharArray();
        }
        int k = sc.nextInt();

        int x = 0;
        int y = 0;
        int ret = 0;
        // 상단에서 들어오는 경우 1 ~ N
        if(k <= n) {
            x = k-1;
            y = -1;
            ret = move(x, y, "S", arr);
        } else if(k <= 2 * n) {
            // 우측에서 들어오는 경우 N+1 ~ 2N
            x = n;
            y = k-n-1;
            ret = move(x, y, "W", arr);
        } else if(k <= 3 * n) {
            // 하단에서 들어오는 경우 2N + 1 ~ 3N    
            x = n-1 - (k - (2 * n)- 1);
            y = n;
            ret = move(x, y, "N", arr);
        } else {
            // 좌측에서 들어오는 경우 3N + 1 ~ 4N
            x = -1;
            y = n-1 - (k - (3 * n) - 1);
            ret = move(x, y, "E", arr);
        }

        System.out.println(ret);
    }

    public static int move(int x, int y, String dir, char[][] arr) {
        int ret = 0;
        int curX = x;
        int curY = y;
        int n = arr.length;
        int cnt = 0;
        String d = dir;

        while(true) {
            // System.out.println(String.format("[%d, %d]", curY, curX));
            if(d.equals("N")) {
                curY = curY - 1;
            } else if (d.equals("E")) {
                curX = curX + 1;
            } else if (d.equals("S")) {
                curY = curY + 1;
            } else if (d.equals("W"))  {
                curX = curX - 1;
            }

            if(!inRange(curX, curY, n)) break;
            d = arr[curY][curX] == '/' ? moveCase1(d) : moveCase2(d);
            cnt++;
        }

        return cnt;
    }

    // /칸에 Dir방향에서 레이저가 들어왔을 때 다음으로 이동할 칸 [y, x]
    public static String moveCase1(String dir) {
        if(dir.equals("S")) {
            // x, y를 왼쪽으로 한칸 변경
            return "W";
        } else if(dir.equals("W")) {
            // x, y를 아래칸으로 변경
            return "S";
        } else if(dir.equals("N")) {
            // x, y를 오른쪽으로 한칸 변경
            return "E";
        } else {
            return "N";
        }
    }
    
    // \칸에 Dir방향에서 레이저가 들어왔을 때 다음으로 이동할 칸 [y, x]
    public static String moveCase2(String dir) {
        if(dir.equals("S")) {
            // x, y를 오른으로 한칸 변경
            return "E";
        } else if(dir.equals("W")) {
            // x, y를 위칸으로 변경
            return "N";
        } else if(dir.equals("N")) {
            // x, y를 왼쪽으로 한칸 변경
            return "W";
        } else {
            return "S";
        }
    }

    public static boolean inRange(int x, int y, int n) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }
}