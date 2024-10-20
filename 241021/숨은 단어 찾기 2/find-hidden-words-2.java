import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;
    static char[][] arr;
    static final String LEE = "LEE";
    static int cnt = 0;

    public static void main(String[] args) {
            input();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    case1(j, i);
                    case2(j, i);
                    case3(j, i);
                    case4(j, i);
                }
            }

            // case4(N-1)
            System.out.println(cnt);

    }
    // /대각선으로 세기 3점의 좌표를 받아서 시작 끝 거꾸로도 해봐야함.
    public static void case1(int x, int y) {
        int[] dx = {0, 1, 2};
        int[] dy = {0, -1, -2};
        char[] chars = new char[3];

        for(int dir = 0; dir < 3; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx, ny)) return;
            chars[dir] = arr[ny][nx];
        }

        String str1 = "" + chars[0] + chars[1] + chars[2];
        String str2 = "" + chars[2] + chars[1] + chars[0];

        if(str1.equals(LEE)) {
            cnt++;
            // System.out.println(String.format("[%d %d]", y, x));
        }
        if(str2.equals(LEE)) {
            cnt++;
            // System.out.println(String.format("[%d %d]", y, x));
        }
    }

    // \대각선으로 세기 3점의 좌표를 받아서 시작 끝 거꾸로도 해봐야함.
    public static void case2(int x, int y) {
        int[] dx = {0, 1, 2};
        int[] dy = {0, 1, 2};
        char[] chars = new char[3];

        for(int dir = 0; dir < 3; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx, ny)) return;
            chars[dir] = arr[ny][nx];
        }

        String str1 = "" + chars[0] + chars[1] + chars[2];
        String str2 = "" + chars[2] + chars[1] + chars[0];

        if(str1.equals(LEE)) {
            cnt++;
            // System.out.println(String.format("[%d %d]", y, x));
        }

        if(str2.equals(LEE)) {
            cnt++;
            // System.out.println(String.format("[%d %d]", y, x));
        }
    }

    // 가로 방향으로 세기 3점의 좌표를 받아서 시작 끝 거꾸로도 해봐야함.
    public static void case3(int x, int y) {
        int[] dx = {0, 1, 2};
        int[] dy = {0, 0, 0};
        char[] chars = new char[3];

        for(int dir = 0; dir < 3; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx, ny)) return;
            chars[dir] = arr[ny][nx];
        }

        String str1 = "" + chars[0] + chars[1] + chars[2];
        String str2 = "" + chars[2] + chars[1] + chars[0];

        if(str1.equals(LEE)) {
            cnt++;
            // System.out.println(String.format("[%d %d]", y, x));
        }
        if(str2.equals(LEE)) {
            cnt++;
            // System.out.println(String.format("[%d %d]", y, x));
        }
    }

    // 세로 방향으로 세기 3점의 좌표를 받아서 시작 끝 거꾸로도 해봐야함.
    public static void case4(int x, int y) {
        int[] dx = {0, 0, 0};
        int[] dy = {0, 1, 2};
        char[] chars = new char[3];

        for(int dir = 0; dir < 3; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx, ny)) return;
            chars[dir] = arr[ny][nx];
        }

        String str1 = "" + chars[0] + chars[1] + chars[2];
        String str2 = "" + chars[2] + chars[1] + chars[0];

        if(str1.equals(LEE)) {
            cnt++;
            // System.out.println(String.format("[%d %d]", y, x));
        }
        if(str2.equals(LEE)) {
            cnt++;
            // System.out.println(String.format("[%d %d]", y, x));
        }
    }

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < M) && (0 <= y && y < N);
    }

    public static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.next().toCharArray();
        }
    }
}