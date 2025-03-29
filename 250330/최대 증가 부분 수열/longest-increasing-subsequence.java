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
	}

	public static void main(String[] args) {
		input();

		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[i] <= arr[j])
					continue;
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}