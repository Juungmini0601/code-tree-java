import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Main {
    public static final int MAX_N = 8;
    public static final int DIR_NUM = 4;

    public static int n, k, u, d;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    // 시티들의 좌표
    public static List<Pair> cityPos = new ArrayList<>();
    public static List<Pair> selectedCityPos = new ArrayList<>();
    // 큐
    public static Queue<Pair> q = new LinkedList<>();
    public static int maxCnt = 0;

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void initializeVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void simulate() {
        initializeVisited();
        int cnt = 0;

        for(int i = 0; i < selectedCityPos.size(); i++) {
            q.add(selectedCityPos.get(i));
            cnt++;
            visited[selectedCityPos.get(i).x][selectedCityPos.get(i).y] = true;
        }

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int currX = curr.x;
            int currY = curr.y;

            for(int i = 0; i < DIR_NUM; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if(inRange(nx, ny) && !visited[nx][ny]) {
                    int h1 = grid[currX][currY];
                    int h2 = grid[nx][ny];
                    int diff = Math.abs(h1 - h2);

                    if(diff >= u && diff <= d) {
                        cnt++;
                        q.add(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        maxCnt = Math.max(maxCnt, cnt);
    }

    public static void combination(int idx, int cnt) {
         if(cnt > k)
            return;
        
        if(idx == n * n) {
            if(cnt == k)
                ans = Math.max(ans, calc());
            return;
        }

        combination(idx + 1, cnt);
        selectedCityPos.add(cityPos.get(idx));
        combination(idx + 1, cnt + 1);
        selectedCityPos.remove(selectedCityPos.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                cityPos.add(new Pair(i, j));
            }
        }

        combination(0, 0);
        System.out.println(maxCnt);
    }
}