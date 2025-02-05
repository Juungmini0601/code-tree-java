import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이용 코드 - 수들의 합 최대화 하기
 *
 * n * n 크기의 2차원 격자가 주어짐
 * 각 행과 열에서 1개의 칸만 색칠한 수들의 합의 최대 값을 구하시오
 * -> 걍 1 ~ n까지 선택하는 문제
 */
public class Main {

	public static int n;
	public static int[][] arr;
	public static int[] selected;
	public static boolean[] visited;
	public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static int ans = 0;

	public static void main(String[] args) throws Exception {
		input();
		choose(1);
		System.out.println(ans);
	}

	public static void choose(int cur) {
		if (cur == n + 1) {
			ans = Math.max(ans, getSum());
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

	public static int getSum() {
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum += arr[i][selected[i]];
		}

		return sum;
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
