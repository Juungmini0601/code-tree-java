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

	public static void main(String[] args) {
		input();

		dp[0] = 0;

		for (int i = 1; i <= m; i++) {
			for (int coin : arr) {
				if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}

		System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
	}
}