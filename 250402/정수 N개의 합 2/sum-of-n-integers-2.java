import java.util.Scanner;

// N개의 원소로 이루어진 수열이 주어질때 연속하는 K개의 원소들의 합 중 가장 큰 값을 구하시오
public class Main {
	public static int n, k;
	public static int[] arr;
	public static int[] sums;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		sums = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
	}

	public static void prefixSum() {
		sums[0] = arr[0];

		for (int i = 1; i < n; i++) {
			sums[i] = sums[i - 1] + arr[i];
		}
	}

	public static void main(String[] args) {
		input();
		prefixSum();

		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= n - k; i++) {
			int cur = sums[i + k - 1];

			if (i != 0) {
				cur -= sums[i - 1];
			}

			max = Math.max(max, cur);
		}

		System.out.println(max);
	}
}