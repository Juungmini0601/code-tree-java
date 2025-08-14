import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public static final int DIR = 4;

    public static int n, h, m;

    public static int[][] grid = new int[MAX_N][MAX_N];
    public static List<Pair> sPos = new ArrayList<>();

    public static Queue<Pair> q = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int[][] distance = new int[MAX_N][MAX_N];

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] != 1 && !visited[x][y];
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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if(grid[i][j] == 3) {
                    sPos.add(new Pair(i, j));
                }
            }
        }

        for(Pair s : sPos) {
            push(s.x, s.y, 0);
        }

        bfs();

        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 2)
                    System.out.print(0 + " ");
                else {
                    if(!visited[i][j])
                        System.out.print(-1 + " ");
                    else
                        System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}