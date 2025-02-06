import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이용 코드 - 외판원 순회
 *
 */
public class Main {

	public static int n;
	public static int[][] arr;
	public static int[] selected;
	public static boolean[] visited;
	public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		input();
		visited[1] = true;
		selected[1] = 1;
		choose(2);
		System.out.println(ans);
	}

	public static void choose(int cur) {
		if (cur == n + 1) {
			ans = Math.min(ans, calcCost());
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				selected[cur] = i;
				visited[i] = true;
				choose(cur + 1);
				visited[i] = false;
			}
		}
	}

	public static int calcCost() {
		int cost = 0;

		for (int i = 1; i <= n - 1; i++) {
			cost += arr[selected[i]][selected[i + 1]];
		}

		cost += arr[selected[n]][selected[1]];
		return cost;
	}

	public static void input() throws Exception {
		n = Integer.parseInt(bufferedReader.readLine());
		selected = new int[n + 1];
		visited = new boolean[n + 1];
		arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
	}
}
