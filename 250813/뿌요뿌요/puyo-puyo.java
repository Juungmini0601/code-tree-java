import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static final int DIR = 4;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    // 터지는 영역의 개수
    public static int areaCnt = 0;
    // 터지는 영역 중 가장 큰 영역의 너비
    public static int maxAreaSize = -1;
    public static int size = 0;
    
    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y, int v) {
        if(!inRange(x, y)) {
            return false;
        }

        if(visited[x][y] || grid[x][y] != v) {
            return false;
        }

        return true;
    }

    public static void DFS(int x, int y, int v) {
        for(int i = 0; i < DIR; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(canGo(nextX, nextY, v)) {
                visited[nextX][nextY] = true;
                size++;
                DFS(nextX, nextY, v);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    size = 1;
                    DFS(i, j, grid[i][j]);

                    if (size >= 4) {
                        areaCnt++;
                    }
                    
                    maxAreaSize = Math.max(maxAreaSize, size);
                }
            }
        }

        System.out.println(areaCnt + " " + maxAreaSize);
    }
}