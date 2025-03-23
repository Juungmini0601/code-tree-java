import java.util.Scanner;

public class Main {

	public static int n, m;
	public static int[] arr;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();

		 for(int i = 0 ; i < m; i++) {
			 int number = sc.nextInt();
			 int index = binarySearch(number);
			 System.out.println((index == -1) ? -1 : index + 1);
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

	public static int binarySearch(int number) {
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == number) {
				return mid;
			} else if (arr[mid] < number) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}
}
