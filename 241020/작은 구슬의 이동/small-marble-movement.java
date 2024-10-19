import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();        
        int r = sc.nextInt();
        int c = sc.nextInt();
        String d = sc.next();
        // 상 우 하 좌
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        // System.out.println(dirToNum(d));
        for(int i = 0; i < t; i++) {
            int dir = dirToNum(d);
            int nextR = r + dy[dir];
            int nextC = c + dx[dir];

            if(!inRange(nextR, nextC, n)) {
                d = reverseDir(d);
                continue;
            }

            r = nextR;
            c = nextC;
        }

        System.out.println(String.format("%d %d", r, c));
    }

    public static boolean inRange(int r, int c, int n) {
        return (1 <= r && r <= n) && (1 <= c && c <= n);
    }

    public static int dirToNum(String dir) {
        int ret = -1;

        switch(dir) {
            case "U":
                ret = 0;
                break;
            case "R":
                ret = 1;
                break;
            case "D":
                ret = 2;
                break;
            case "L":
                ret = 3;
                break;
        }

        return ret;
    }

    public static String reverseDir(String dir) {
        String ret = "";

        switch(dir) {
            case "U":
                ret = "D";
                break;
            case "R":
                ret = "L";
                break;
            case "D":
                ret = "U";
                break;
            case "L":
                ret = "R";
                break;
        }

        return ret;
    }
}