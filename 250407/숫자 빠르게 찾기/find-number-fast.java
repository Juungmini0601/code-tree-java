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

	public static int binarySearch(int target) {
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		input();
		for (int target : targets) {
			int index = binarySearch(target);
			if (index == -1) {
				System.out.println(index);
			} else {
				System.out.println(index + 1);
			}
		}
	}
}