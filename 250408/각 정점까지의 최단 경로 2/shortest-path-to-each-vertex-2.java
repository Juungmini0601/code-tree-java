import java.util.Scanner;

public class Main {

	public static int n, m;
	public static int[][] graph;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();

		graph = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				graph[i][j] = (int)1e9;
			}
			// 자기 자신 까지 가는 거리
			graph[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();

			graph[start][end] = Math.min(graph[start][end], cost);
		}
	}

	public static void warshal() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (graph[i][k] + graph[k][j] < graph[i][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		warshal();

		// 모든 쌍에 대한 최단거리 결과를 출력합니다.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] == (int)1e9)
					System.out.print(-1 + " ");
				else
					System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}