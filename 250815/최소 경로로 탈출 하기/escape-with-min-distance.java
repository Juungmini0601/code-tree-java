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
    public static final int MAX_M = 100;

    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_M];

    public static boolean[][] visited = new boolean[MAX_N][MAX_M];
    public static int[][] distance = new int[MAX_N][MAX_M];
    
    public static Queue<Pair> q = new LinkedList<>();


    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static int ans = Integer.MAX_VALUE;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 1 && !visited[x][y];
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

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGo(nx, ny)) {
                    push(nx, ny, distance[x][y] + 1);
                }
            }
        }

        if(visited[n - 1][m - 1]) {
            ans = Math.min(ans, distance[n - 1][m - 1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        push(0, 0, 0);
        bfs();

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }
    
}
