import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int n, m;
	public static int[] arr;
	public static int[] dp;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		dp = new int[m + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.fill(dp, Integer.MAX_VALUE);
	}

	public static void solve() {
		dp[0] = 0;

		// i 번째 원소를 마지막으로 할때 dp[0~m]까지를 계속 갱신할 거임
		for (int i = 0; i < n; i++) {
			for (int j = m; j >= 0; j--) {
				if (j >= arr[i] && dp[j - arr[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
				}
			}
		}

	}

	public static void main(String[] args) {
		input();
		solve();
		System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
	}
}