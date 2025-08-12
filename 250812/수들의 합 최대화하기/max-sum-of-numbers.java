import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final int MAX_N = 10;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[] visited = new boolean[MAX_N];
    public static List<Integer> selected = new ArrayList<>();

    public static int ans = 0;

    public static Scanner sc = new Scanner(System.in);

    public static void findMax(int row) {
        if(row == n) {
            int sum = 0;
            for(int i = 0; i < selected.size(); i++) {
                sum += grid[i][selected.get(i)];
            }

            ans = Math.max(ans, sum);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected.add(i);

            findMax(row + 1);

            selected.remove(selected.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        findMax(0);

        System.out.println(ans);
    }
}