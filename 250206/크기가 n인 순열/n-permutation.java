import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 알고리즘 풀이용 코드 - 크기가 n인 순열
 *
 * 1부터 n까지의 수를 정확히 한 번씩만 사용하여 만들 수 있는 가능한 모든 수열을 구해주는 프로그램을 작성해보세요.
 */
public class Main {

	public static int n;
	public static int[] selected;
	public static boolean[] visited;
	public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		choose(1);
	}

	public static void choose(int cur) {
		if (cur == n + 1) {
			printSelected();
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

	public static void printSelected() {
		for (int i = 1; i <= n; i++) {
			System.out.print(selected[i] + " ");
		}
		System.out.println();
	}

	public static void input() throws Exception {
		n = Integer.parseInt(bufferedReader.readLine());
		selected = new int[n + 1];
		visited = new boolean[n + 1];
	}
}
