import java.util.Scanner;

// n개의 정점과 m개의 간선으로 이루어진 양방향 그래프가 있다.
// 1번 정점에서 시작하여 주어진 간선을 따라 이동 했을 때 도달 할 수 있는 서로 다른 정점의 수를 구하시오
// 1번 정점이 자기 자신에 도달하는 경우는 가지수에서 제외한다.
public class Main {

	public static int n, m;
	public static int[][] graph;
	public static boolean[] visited;
	public static int count = 0;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();

		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			graph[a][b] = 1;
			graph[b][a] = 1;
		}
	}

	public static void dfs(int curV) {
		for (int i = 1; i <= n; i++) {
			if (graph[curV][i] == 1 && !visited[i]) {
				visited[i] = true;
				count++;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		input();
		visited[1] = true;
		dfs(1);

		System.out.println(count);
	}
}