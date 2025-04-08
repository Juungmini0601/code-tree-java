import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int n;
	public static boolean[] visited;
	public static int[] parent;

	public static List<Integer>[] graph;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		visited = new boolean[n + 1];
		parent = new int[n + 1];
		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			parent[i] = i;
		}

		for (int i = 1; i <= n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			graph[a].add(b);
			graph[b].add(a);
		}
	}

	public static void dfs(int v) {
		visited[v] = true;

		for (int i = 0; i < graph[v].size(); i++) {
			int next = graph[v].get(i);

			if (!visited[next]) {
				parent[next] = v;
				dfs(next);
			}
		}
	}

	public static void main(String[] args) {
		input();
		dfs(1);

		for (int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}
	}
}