import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int n, m;
	public static int[] coins;
	public static int[] dp;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		
		for(int i = 1; i <= m; i++) {
			for(int j = 0; j < n; j++) {
				if(i >= coins[j] && dp[i - coins[j]] != Integer.MIN_VALUE) {
					dp[i] = Math.max(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}

		System.out.println(dp[m] == Integer.MIN_VALUE ? -1 : dp[m]);
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		coins = new int[n];
		dp = new int[m + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}
	}
}