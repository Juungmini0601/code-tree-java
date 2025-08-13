import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static final int MAX_NUM = 25;
    public static final int DIR = 4;

    public static int n;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];

    // 아래 오른쪽 위 왼쪽
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static List<Integer> peopleCounts = new ArrayList<>();
    public static int peopleCount = 0;

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
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
                peopleCount++;
                DFS(nextX, nextY);
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
                if(grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    peopleCount = 1;
                    DFS(i, j);
                    peopleCounts.add(peopleCount);
                }
            }
        }

        Collections.sort(peopleCounts);

        System.out.println(peopleCounts.size());
        for(int count : peopleCounts) {
            System.out.println(count);
        }
    }
}
