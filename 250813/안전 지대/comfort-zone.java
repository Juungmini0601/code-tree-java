import java.util.Scanner;

public class Main {
    public static final int DIR = 4;
    public static final int MAX_HEIGHT = 100;
    public static final int MAX_M = 50;
    public static final int MAX_N = 50;

    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_M];
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];
    public static int zoneNum = 0;
    public static int maxZoneNum = 0;
    public static int answerK = 0;
    

    // 아래 오른쪽 위 왼쪽
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void initializeVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y, int k) {
        if(!inRange(x, y)) {
            return false;
        }

        if(visited[x][y] || grid[x][y] <= k) {
            return false;
        }

        return true;
    }

    public static void DFS(int x, int y, int k) {
        for(int i = 0; i < DIR; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(canGo(nextX, nextY, k)) {
                visited[nextX][nextY] = true;
                DFS(nextX, nextY, k);
            }
        }
    }

    public static void getZoneNum(int k) {
        zoneNum = 0;
        initializeVisited();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(canGo(i, j, k)) {
                    visited[i][j] = true;
                    zoneNum++;

                    DFS(i, j, k);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        maxZoneNum = -1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int k = 1; k <= MAX_HEIGHT; k++) {
            getZoneNum(k);

            if(zoneNum > maxZoneNum) {
                maxZoneNum = zoneNum;
                answerK = k;
            }
        }

        System.out.println(answerK + " " + maxZoneNum);
    }
}