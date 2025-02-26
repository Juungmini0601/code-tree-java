import java.util.Scanner;

public class Main {

	public static int n;
	public static int[] dp;
	public static int[] numbers = {1, 2, 5};

	public static final int MOD = 10_007;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		dp = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int number : numbers) {
				if (i >= number) {
					dp[i] = (dp[i] + dp[i - number]) % MOD;
				}
			}
		}

		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}

}