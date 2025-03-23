import java.util.Scanner;

public class Main {

	public static int n, m;
	public static int[] arr;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();

		 for(int i = 0 ; i < m; i++) {
			 int number = sc.nextInt();
			 int count = upperBound(number) - lowerBound(number);
			 System.out.println(count);
		 }
	}

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
	}

	public static int lowerBound(int number) {
		int left = 0;
		int right = n - 1;
		int minIndex = n;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] >= number) {
				right = mid - 1;
				minIndex = Math.min(minIndex, mid);
			} else {
				left = mid + 1;
			}
		}

		return minIndex;
	}

	public static int upperBound(int number) {
		int left = 0;
		int right = n - 1;
		int minIndex = n;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] > number) {
				right = mid - 1;
				minIndex = Math.min(minIndex, mid);
			} else {
				left = mid + 1;
			}
		}

		return minIndex;
	}
}
