import java.util.Scanner;

public class Main {

	public static final int MAX_NUM = 1000;
	public static final int MOD = 10_007;

	public static int[] dp = new int[MAX_NUM + 1];
	public static int n;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();
		step(n);
		System.out.println(dp[n]);
	}

	public static void step(int n) {
		if (n - 3 < 1) {
			return;
		}

		if (dp[n - 2] == 0) {
			step(n - 2);
		}

		dp[n] += dp[n - 2];
		dp[n] %= MOD;

		if (dp[n - 3] == 0) {
			step(n - 3);
		}

		dp[n] += dp[n - 3];
		dp[n] %= MOD;
	}

	public static void input() {
		n = sc.nextInt();
		dp[2] = 1;
		dp[3] = 1;
	}
}
