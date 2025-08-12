import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static final int MAX_N = 10;
    
    public static int n;
    public static int[][] cost = new int[MAX_N][MAX_N];
    public static boolean[] visited = new boolean[MAX_N];
    public static List<Integer> selected = new ArrayList<>();

    public static int ans = Integer.MAX_VALUE;

    public static void findMin(int cnt) {
        if(cnt == n) {
            int totalCost = 0;
            for(int i = 0; i < selected.size() - 1; i++) {
                totalCost += cost[selected.get(i)][selected.get(i + 1)];
            }
            totalCost += cost[selected.get(selected.size() - 1)][selected.get(0)];
            ans = Math.min(ans, totalCost);
            return;
        }
        

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected.add(i);

            findMin(cnt + 1);

            selected.remove(selected.size() - 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        findMin(0);
        System.out.println(ans);
    }
}