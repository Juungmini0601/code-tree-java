import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];

        for(int i = 0; i < n; i++) {
            points[i] = new Point(i+1, sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(points);
        for(int i = 0; i < n; i++) {
            System.out.println(points[i]);
        }
    }
}

class Point implements Comparable<Point> {
    int index;
    int x;
    int y;

    public Point(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return (Math.abs(this.x) + Math.abs(this.y)) - (Math.abs(p.x) + Math.abs(p.y));
    }

    @Override
    public String toString() {
        return "" + index;
    }
}