import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final Pair NOT_EXIST = new Pair(-1, -1);
    public static final int MAX_NUM = 100;
    public static final int DIR = 4;

    public static int n, k;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];
   
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static Pair currentCell;
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y, int targetNum) {
        return inRange(x, y) && grid[x][y] < targetNum && !visited[x][y];
    }

    public static void initializeVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void bfs() {
        int cx = currentCell.x;
        int cy = currentCell.y;

        visited[cx][cy] = true;
        q.add(currentCell);

        int targetNum = grid[cx][cy];

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int currX = curr.x;
            int currY = curr.y;

            for(int i = 0; i < DIR; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if(canGo(nx, ny, targetNum)) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static boolean needUpdate(Pair bestPos, Pair newPos) {
        if(bestPos.x == NOT_EXIST.x && bestPos.y == NOT_EXIST.y) {
            return true;
        }

        int bestX = bestPos.x;
        int bestY = bestPos.y;
        int newX = newPos.x;
        int newY = newPos.y;

        if(grid[newX][newY] != grid[bestX][bestY]) {
            return grid[newX][newY] > grid[bestX][bestY];
        }

        if(-newX != -bestX) {
            return -newX > -bestX;
        }

        return -newY > -bestY;
    }

    public static boolean move() {
        initializeVisited();
        bfs();

        Pair bestPos = NOT_EXIST;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] || i == currentCell.x && j == currentCell.y) {
                    continue;
                }

                Pair newPos = new Pair(i, j);

                if(needUpdate(bestPos, newPos)) {
                    bestPos = newPos;
                }
            }
        }

        if(bestPos.x == NOT_EXIST.x && bestPos.y == NOT_EXIST.y) {
            return false;
        }

        currentCell = bestPos;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int r = sc.nextInt();
        int c = sc.nextInt();

        currentCell = new Pair(r - 1, c - 1);

        for(int i = 0; i < k; i++) {
            boolean isMoved = move();

            if(!isMoved) {
                break;
            }
        }

        System.out.println(currentCell.x + 1 + " " + (currentCell.y + 1));
    }
}