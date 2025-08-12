import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 10;

    public static int n;
    public static List<Integer> selected = new ArrayList<>();
    public static boolean[] visited = new boolean[MAX_N];
    public static int[][] grid = new int[MAX_N][MAX_N];

    public static int ans = Integer.MIN_VALUE;

    public static void findMin(int row) {
        if(row == n) {
            int min = grid[0][selected.get(0)];
            for(int i = 1; i < selected.size(); i++) {
                min = Math.min(min, grid[i][selected.get(i)]);
            }
            ans = Math.max(ans, min);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected.add(i);

            findMin(row + 1);

            selected.remove(selected.size() - 1);
            visited[i] = false;
        }
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        findMin(0);
        System.out.println(ans);
    }
}