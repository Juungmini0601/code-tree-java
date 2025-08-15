import java.util.Scanner;

public class Main {

	public static int n;

	public static final int MOD = 10_007;
	static int[] dp = new int[1001];

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % MOD;
		}

		System.out.println(dp[n]);
	}
}