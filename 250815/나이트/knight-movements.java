import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static final int MAX_N = 100;
    public static final int DIR = 8;

    public static int n;
    public static int r1, c1, r2, c2;

    public static Queue<Pair> q = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int[][] distance = new int[MAX_N][MAX_N];

    public static int[] dx = new int[]{-2, -2, -1, -1,  1, 1,  2, 2};
    public static int[] dy = new int[]{-1,  1, -2,  2, -2, 2, -1, 1};

    public static int ans = Integer.MAX_VALUE;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && !visited[x][y];
    }

    public static void push(int x, int y, int d) {
        q.add(new Pair(x, y));
        visited[x][y] = true;
        distance[x][y] = d;
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for (int i = 0; i < DIR; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGo(nx, ny)) {
                    push(nx, ny, distance[x][y] + 1);
                }
            }
        }

        if (visited[r2][c2]) {
            ans = Math.min(ans, distance[r2][c2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;

        push(r1, c1, 0);
        bfs();

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }
}