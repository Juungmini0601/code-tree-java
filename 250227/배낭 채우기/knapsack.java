import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static class Gem {
		int w;
		int v;

		public Gem(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	public static int n, m;
	public static Gem[] gems;
	public static int[][] dp;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();

		// 1번 부터 N까지의 보석을 본다.
		for (int i = 1; i <= n; i++) {
			// 현재 보석에 왔을때 갈 수 있는 무게는 이전 최대 값을 활용해서 구할 수 있다.
			for (int j = 1; j <= m; j++) {
				int w = gems[i].w;
				int v = gems[i].v;
				// 현재 보석이 들어갈 수 없는 경우이다.
				if (j < w) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
				}
			}
		}

		int max = Arrays.stream(dp[n]).max().getAsInt();
		System.out.println(max);
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		gems = new Gem[n + 1];
		dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			gems[i] = new Gem(w, v);
		}
	}
}