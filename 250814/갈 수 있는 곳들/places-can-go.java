import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static final int MAX_NUM = 100;
    public static final int DIR = 4;

    public static int n, k;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];

    public static Queue<Pair> q = new LinkedList<>();

    // 상 우 하 좌
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 0 && !visited[x][y];
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int i = 0; i < DIR; i++) {
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
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            visited[x][y] = true;
            q.add(new Pair(x, y));
        }

        BFS();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}