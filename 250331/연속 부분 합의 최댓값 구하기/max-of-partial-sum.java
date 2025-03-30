import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int n;
	public static int[] arr;
	public static int[] dp;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		arr = new int[n];
		dp = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.fill(dp, Integer.MIN_VALUE);
	}

	public static void solve() {
		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
		}
	}

	public static void main(String[] args) {
		input();
		solve();
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}