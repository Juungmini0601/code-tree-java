import java.util.Scanner;

// N개의 원소로 이루어진 수열이 주어질때 연속하는 K개의 원소들의 합 중 가장 큰 값을 구하시오
public class Main {
	public static int n, k;
	public static int[][] arr;
	public static int[][] sums;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n + 1][n + 1];
		sums = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}

	// [0, 0] ~ [i, j] 까지의 합을 구하겠다.
	public static void prefixSum() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + arr[i][j];
			}
		}
	}

	public static void main(String[] args) {
		input();
		prefixSum();

		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= n - k + 1; i++) {
			for (int j = 1; j <= n - k + 1; j++) {
				int startRow = i;
				int startCol = j;
				int endRow = i + k - 1;
				int endCol = j + k - 1;

				int temp = sums[endRow][endCol] - sums[startRow - 1][endCol] - sums[endRow][startCol - 1] + sums[startRow - 1][startCol - 1];
				max = Math.max(max, temp);
			}
		}

		System.out.println(max);
	}
}