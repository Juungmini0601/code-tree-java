import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



public class Main {
    public static final int DIR = 4;
    public static final int MAX_N = 100;

    public static int n, k, m;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static Queue<Pair> q = new LinkedList<>();

    public static int ans;

    public static List<Pair> sPos = new ArrayList<>();
    public static List<Pair> stonePos = new ArrayList<>();
    public static List<Pair> selectedStones = new ArrayList<>();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && !visited[x][y] && grid[x][y] == 0;
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int currX = curr.x;
            int currY = curr.y;

            for(int i = 0; i < DIR; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static int calc() {
        for(int i = 0; i < m; i++) {
            Pair curr = selectedStones.get(i);
            int currX = curr.x;
            int currY = curr.y;

            grid[currX][currY] = 0;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        
        for(int i = 0; i < k; i++) {
            q.add(sPos.get(i));
            visited[sPos.get(i).x][sPos.get(i).y] = true;
        }

        bfs();

        
        for(int i = 0; i < m; i++) {
            Pair curr = selectedStones.get(i);
            int currX = curr.x;
            int currY = curr.y;

            grid[currX][currY] = 1;
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void findMax(int idx, int cnt) {
        if (idx == stonePos.size()) {
            if(cnt == m) {
                ans = Math.max(ans, calc());
            }
            return;
        }

        findMax(idx + 1, cnt);

        selectedStones.add(stonePos.get(idx));
        findMax(idx + 1, cnt + 1);
        selectedStones.remove(selectedStones.size() - 1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    stonePos.add(new Pair(i, j));
                }
            }
        }

        for(int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            sPos.add(new Pair(r - 1, c - 1));
        }

        findMax(0, 0);

        System.out.println(ans);
    }
}