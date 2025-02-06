import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이용 코드 - 외판원 순회
 *
 */
public class Main {

	public static int n, m;
	public static int[][] arr;
	public static boolean[] visited;
	public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static int cnt = 0;

	public static void main(String[] args) throws Exception {
		input();
		visited[1] = true;
		DFS(1);
		System.out.println(cnt);
	}

	public static void DFS(int currentVertex) {
		for (int nextVertex = 1; nextVertex <= n; nextVertex++) {
			if (arr[currentVertex][nextVertex] == 1 && !visited[nextVertex]) {
				visited[nextVertex] = true;
				cnt++;
				DFS(nextVertex);
			}
		}
	}

	public static void input() throws Exception {
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		visited = new boolean[n + 1];
		arr = new int[n + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			int a = Integer.parseInt(stringTokenizer.nextToken());
			int b = Integer.parseInt(stringTokenizer.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}
	}
}
