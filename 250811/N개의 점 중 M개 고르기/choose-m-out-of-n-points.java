import java.util.ArrayList;
import java.util.Scanner;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static final int MAX_N = 20;

    public static int n, m;
    public static Pair[] points = new Pair[MAX_N];

    public static ArrayList<Pair> selectedPoints = new ArrayList<>();

    public static int ans = Integer.MAX_VALUE;

    public static int dist(Pair a, Pair b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static int calc() {
        int maxDist = 0;

        for(int i = 0; i < m - 1; i++) {
            for(int j = i + 1; j < m; j++) {
                maxDist = Math.max(maxDist, dist(selectedPoints.get(i), selectedPoints.get(j)));
            }
        }

        return maxDist;
    }

    public static void findMin(int currentIndex, int count) {
        if(count == m) {
            ans = Math.min(ans, calc());
            return;
        }
        
        if(currentIndex >= n) {
            return;
        }

        selectedPoints.add(points[currentIndex]);
        findMin(currentIndex + 1, count + 1);
        selectedPoints.remove(selectedPoints.size() - 1);

        findMin(currentIndex + 1, count);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            points[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        findMin(0, 0);
        System.out.println(ans);
    }
}