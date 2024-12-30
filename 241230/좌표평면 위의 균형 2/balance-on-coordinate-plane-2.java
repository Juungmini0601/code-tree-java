import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static Point[] points;

    public static void main(String[] args) throws Exception {
        input();
        int ans = Integer.MAX_VALUE;

        for(int x = 2; x <= 100; x += 2) {
            for(int y = 2; y <= 100; y +=2 ) {
                ans = Math.min(ans, getMaxCount(x, y));
            } 
        }

        System.out.println(ans);
    }

    public static int getMaxCount(int x, int y) {
        int[] counts = new int[5];

        for(int i = 0; i < n; i++) {
            Point p = points[i];
            int px = p.x;
            int py = p.y;

            // 1사분면
            if(px > x && py > y) {
                counts[1]++;
                continue;
            }
            // 2사분면
            if(px < x && py > y) {
                counts[2]++;
                continue;
            }
            // 3사분면
            if(px < x && py < y) {
                counts[3]++;
            }
            // 4사분면
            if(px > x && py < y) {
                counts[4]++;
            }
        }

        int ans = counts[1];
        for(int i = 2; i <= 4; i++) {
            ans = Math.max(ans, counts[i]);
        }

        return ans;
    }

    public static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        points = new Point[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Point p = new Point(x, y);
            points[i] = p;
        }
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}