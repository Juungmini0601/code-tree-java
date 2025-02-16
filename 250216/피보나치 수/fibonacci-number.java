import java.util.Scanner;

public class Main {

	public static int[] dp = new int[46];
	public static int n;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[n]);
	}

	public static void input() {
		n = sc.nextInt();
		dp[1] = 1;
		dp[2] = 1;
	}
}
