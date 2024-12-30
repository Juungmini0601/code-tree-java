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

        // 0 ~ 10까지는 x축에 평행한 직선
        // 11 ~ 21까지는 y축에 평행한 직선
        for(int l1 = 0; l1 <= 21; l1++) {
            for(int l2 = 0; l2 <= 21; l2++) {
                for(int l3 = 0; l3 <= 21; l3++) {
                    if(l1 == l2 || l2 == l3 || l1 == l3) {
                        continue;
                    }

                    if(check(l1, l2, l3)) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    public static boolean check(int l1, int l2, int l3) {
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            Point p = points[i];

            // x축에 평행한 직선에서 일치하는 값이 있는지 체크
            if(l1 <= 10 && p.y == l1) {
                visited[i] = true;
                continue;
            }

            if(l2 <= 10 && p.y == l2) {
                visited[i] = true;
                continue;
            }

            if(l3 <= 10 && p.y == l3) {
                visited[i] = true;
                continue;
            }

            // y축에 평행한 직선에서 일치하는 값이 있는지 체크
            if(l1 >= 11 && p.x == l1 - 11) {
                visited[i] = true;
                continue;
            } 

            if(l2 >= 11 && p.x == l2 - 11) {
                visited[i] = true;
                continue;
            } 

            if(l3 >= 11 && p.x == l3 - 11) {
                visited[i] = true;
                continue;
            } 
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                return false;
            }
        }

        return true;
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