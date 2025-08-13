import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100;
    public static final int DIR = 2;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];

    // 아래 오른쪽
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) {
            return false;
        }

        if(visited[x][y] || grid[x][y] == 0) {
            return false;
        }

        return true;
    }

    public static void DFS(int x, int y) {
        for(int i = 0; i < DIR; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(canGo(nextX, nextY)) {
                visited[nextX][nextY] = true;
                DFS(nextX, nextY);
            }
        }
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

        visited[0][0] = true;
        DFS(0, 0);
        System.out.println(visited[n - 1][m - 1] ? "1" : "0");
    }
}