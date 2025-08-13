import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 1000;
    public static int n, m;

    public static int[][] graph = new int[MAX_NUM + 1][MAX_NUM + 1];
    public static boolean[] visited = new boolean[MAX_NUM + 1];
    public static int count = 0;

    public static void DFS(int v) {
        for (int i = 1; i <= n; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                count++;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited[1] = true;
        DFS(1);
        System.out.println(count);
    }
}
