import java.util.Scanner;

public class Main {

	public static int n, m;
	public static int[] arr;
	public static int[] targets;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		targets = new int[m];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			targets[i] = sc.nextInt();
		}
	}

	// target 이상인 수가 나오는 최소 값
	public static int lowerBound(int target) {
		int left = 0;
		int right = n - 1;
		int minIndex = n;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] >= target) {
				right = mid - 1;
				minIndex = Math.min(minIndex, mid);
			} else {
				left = mid + 1;
			}
		}

		return minIndex;
	}

	public static int upperBound(int target) {
		int left = 0;
		int right = n - 1;
		int minIndex = n;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] > target) {
				right = mid - 1;
				minIndex = Math.min(minIndex, mid);
			} else {
				left = mid + 1;
			}
		}

		return minIndex;
	}

	public static int count(int target) {
		return upperBound(target) - lowerBound(target);
	}

	public static void main(String[] args) {
		input();
		for (int target : targets) {
			int n = count(target);
			System.out.println(n);
		}
	}
}