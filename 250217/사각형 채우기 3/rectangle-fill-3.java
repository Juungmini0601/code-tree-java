import java.util.Scanner;

public class Main {

	public static final int MAX_NUM = 1000;
	public static final int MOD = 1_000_000_007;

	public static int[] dp = new int[MAX_NUM + 1];
	public static int n;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();

		for (int i = 2; i <= n; i++) {
			dp[i] = 3 * dp[i - 2] + 2 * dp[i - 1];

			for (int j = i - 3; j >= 0; j--) {
				dp[i] = (dp[i] + dp[j] * 2) % MOD;
			}
		}

		System.out.println(dp[n]);
	}

	public static void input() {
		n = sc.nextInt();
		dp[0] = 1;
		dp[1] = 2;
	}
}
