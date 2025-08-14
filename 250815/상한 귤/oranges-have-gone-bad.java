import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 0은 아무것도 없음, 1은 귤, 2는 상한 귤
// k개의 상한 귤 부터 시작해서 1초에 한 번씩 인접한 귤이 모두 상함
// 각 귤이 최초로 상하게 되는 시간
public class Main {
    public static final int MAX_N = 100;

    public static int n, k;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int[][] distance = new int[MAX_N][MAX_N];

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    
    // 상한 귤의 위치   
    public static List<Pair> pos = new ArrayList<>();
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
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

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    push(nx, ny, distance[x][y] + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if(grid[i][j] == 2) {
                    pos.add(new Pair(i, j));
                }
            }
        }

        for(Pair p : pos) {
            push(p.x, p.y, 0);
        }

        bfs();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    System.out.print(-1 + " ");
                } else if(grid[i][j] == 2) {
                    System.out.print(0 + " ");
                } else {
                    if(!visited[i][j]) {
                        System.out.print(-2 + " ");
                    } else {
                        System.out.print(distance[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}