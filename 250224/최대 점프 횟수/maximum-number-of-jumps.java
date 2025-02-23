import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int n;
	public static int[] arr;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == Integer.MIN_VALUE)
					continue;

				if (j + arr[j] >= i) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = Arrays.stream(dp).max().getAsInt();
		System.out.println(max);
	}

	public static void init() {
		n = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
	}
}