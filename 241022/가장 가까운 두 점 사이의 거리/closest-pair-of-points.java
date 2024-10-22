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

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                Point p1 = points[i];
                Point p2 = points[j];

                ans = Math.min(ans, p1.distance(p2));
            }
        }

        System.out.println(ans);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(Point p) {
        int xDiff = this.x - p.x;
        int yDiff = this.y - p.y;

        return xDiff * xDiff + yDiff * yDiff;
    }
}