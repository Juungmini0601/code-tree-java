import java.util.Scanner;

public class Main {

	public static final int MAX_NUM = 1000;
	public static final int MOD = 10_007;

	public static int[] dp = new int[MAX_NUM + 1];
	public static int n;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
		}

		System.out.println(dp[n]);
	}

	public static void input() {
		n = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
	}
}
