import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        int ans = 0;

        for(int i = 0; i < n-2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    Point p1 = points[i];
                    Point p2 = points[j];
                    Point p3 = points[k];

                    if(checkTriangle(p1, p2, p3)) {
                        ans = Math.max(ans, area(p1, p2, p3));
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static boolean checkTriangle(Point p1, Point p2, Point p3) {
        boolean xAxisParallel = false;  // x축에 평행한 선분이 있는지
        boolean yAxisParallel = false;

        if(p1.y == p2.y || p1.y == p3.y || p2.y == p3.y) {
            // 좌표중 2개 이상이 같은 상태이다.
            // 3개 좌표가 모두 같지 않다면 평행한거 마즘
            if(!(p1.y == p2.y && p2.y == p3.y)) {
                xAxisParallel = true;
            }
        }

        if(p1.x == p2.x || p1.x == p3.x || p2.x == p3.x) {
            // 좌표중 2개 이상이 같은 상태이다.
            // 3개 좌표가 모두 같지 않다면 평행한거 마즘
            if(!(p1.x == p2.x && p2.x == p3.x)) {
                yAxisParallel = true;
            }
        }

        return xAxisParallel && yAxisParallel;
    }

    public static int area(Point p1, Point p2, Point p3) {
        return Math.abs((p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x* p1.y + p3.x * p2.y + p1.x * p3.y));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}