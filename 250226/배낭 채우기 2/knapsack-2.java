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

	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();

		for (int i = 1; i <= n; i++) {
			int w = gems[i].w;
			int v = gems[i].v;

			for (int j = 1; j <= m; j++) {
				// 현재 보석은 절대 못고름
				if (j < w) {
					dp[i][j] = dp[i - 1][j];
				} else {
					// 현재 보석을 고를 수 있음
					int temp = Math.max(dp[i - 1][j - w], dp[i][j - w]); // 현재 보석을 고른 경우
					dp[i][j] = Math.max(dp[i][j], temp + v);
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
				}
			}
		}

		// for (int i = 1; i <= n; i++) {
		// 	for (int j = 1; j <= m; j++) {
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

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