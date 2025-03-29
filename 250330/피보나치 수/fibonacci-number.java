import java.util.Scanner;

public class Main {

	public static int n;
	public static int[] dp = new int[46];
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[n]);
	}
}