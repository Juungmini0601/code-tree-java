import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int MAX_M = 200;
    public static final int MAX_N = 200;
    public static final int DIR_NUM = 4;

    public static final int WATER = 0;
    public static final int GLACIER = 1;

    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_M];
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];

    public static Queue<Pair> q = new LinkedList<>();
    public static int cnt;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static int elapsedTime, lastMeltCnt;

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == WATER && !visited[x][y];
    }

    public static void initializeVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void bfs() {
        initializeVisited();

        q.add(new Pair(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int currX = curr.x;
            int currY = curr.y;

            for(int i = 0; i < DIR_NUM; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static boolean outsideWaterExistsNeighbor(int x, int y) {
        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny) && visited[nx][ny]) {
                return true;
            }
        }

        return false;
    }

    public static void melt() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == GLACIER && outsideWaterExistsNeighbor(i, j)) {
                    grid[i][j] = WATER;
                    lastMeltCnt++;
                }
            }
        }
    }

    public static void simulate() {
        elapsedTime++;
        lastMeltCnt = 0;

        bfs();
        melt();
    }

    public static boolean existGlacier() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == GLACIER) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        do {
            simulate();
        } while(existGlacier());

        System.out.println(elapsedTime + " " + lastMeltCnt);
    }
}