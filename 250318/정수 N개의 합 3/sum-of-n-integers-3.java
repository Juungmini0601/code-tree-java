import java.util.Scanner;

public class Main {
	public static int n, k;
	public static int[][] arr;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n + 1][n + 1];
		int[][] prefixSum = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j];
			}
		}

		int ans = Integer.MIN_VALUE;

		for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= n + 1; j++) {
				int x2 = i + k - 1;
				int y2 = j + k - 1;

				if (inRange(x2, y2)) {
					// System.out.printf("[%d, %d] ~ [%d, %d]\n", i, j, x2, y2);
					int sum = prefixSum[x2][y2] - prefixSum[i - 1][y2] - prefixSum[x2][j - 1] + prefixSum[i - 1][j - 1];
					ans = Math.max(sum, ans);
				}
			}
		}

		System.out.println(ans);
	}

	public static boolean inRange(int x, int y) {
		return 1 <= x && x <= n && 1 <= y && y <= n;
	}
}