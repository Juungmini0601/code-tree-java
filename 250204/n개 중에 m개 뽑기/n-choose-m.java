import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이용 코드
 */
public class Main {

	public static int n, m;
	public static boolean[] visited;
	public static int[] selected;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		combination(0);
	}

	public static void combination(int cur) {
		if (cur == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++)
			if (!visited[i]) {
				if (cur == 0) {
					visited[i] = true;
					selected[cur] = i;
					combination(cur + 1);
					visited[i] = false;
				} else {
					if (i > selected[cur - 1]) {
						visited[i] = true;
						selected[cur] = i;
						combination(cur + 1);
						visited[i] = false;
					}
				}
			}
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		selected = new int[m];
	}
}
