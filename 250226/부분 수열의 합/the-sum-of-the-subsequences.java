import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int n, m;
	public static int[] arr;
	public static int[] dp;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = m; j >= 0; j--) {
				if (j >= arr[i] && dp[j - arr[i]] != Integer.MIN_VALUE) {
					dp[j] = Math.max(dp[j], dp[j - arr[i]] + 1);
				}
			}
		}

		System.out.println(dp[m] == Integer.MIN_VALUE ? "No" : "Yes");
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		dp = new int[m + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}