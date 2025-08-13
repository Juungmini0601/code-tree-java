import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static final int MAX_NUM = 100;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];
    public static Queue<Pair> q = new LinkedList<>();
    // 아래 오른쪽 위 왼쪽
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 1 && !visited[x][y];
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if (canGo(newX, newY)) {
                    visited[newX][newY] = true;
                    q.add(new Pair(newX, newY));
                }
            }
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

        visited[0][0] = true;
        q.add(new Pair(0, 0));
        BFS();

        System.out.println(visited[n - 1][m - 1] ? 1 : 0);
    }
}