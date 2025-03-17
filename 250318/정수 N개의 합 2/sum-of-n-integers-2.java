import java.util.Scanner;

public class Main {
	public static int n, k;
	public static int[] arr;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		int[] sums = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		sums[0] = arr[0];
		for (int i = 1; i < n; i++) {
			sums[i] = sums[i - 1] + arr[i];
		}

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i <= n - k; i++) {
			int cur = 0;
			if (i == 0) {
				cur = sums[i + k - 1];
			} else {
				cur = sums[i + k - 1] - sums[i - 1];
			}

			ans = Math.max(ans, cur);
		}

		System.out.println(ans);
	}
}