import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int n;
	public static int[] arr;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			if (dp[i] == 0) {
				dp[i] = 1;
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