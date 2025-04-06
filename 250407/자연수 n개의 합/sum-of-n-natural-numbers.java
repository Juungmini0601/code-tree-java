import java.util.Scanner;

public class Main {
	public static int s;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		s = sc.nextInt();
	}

	// 합이 S이하인 경우 중 N의 최대 값
	// 합이 S보다 큰 경우 중 최소값 -1해주면 될 듯
	public static int search() {
		int left = 0;
		int right = s;
		int minValue = s;

		while (left <= right) {
			int mid = (left + right) / 2;
			int tempSum = mid * (mid + 1) / 2;

			if (tempSum > s) {
				right = mid - 1;
				minValue = Math.min(minValue, mid);
			} else {
				left = mid + 1;
			}
		}

		return minValue;
	}

	public static void main(String[] args) {
		input();
		int value = search();
		System.out.println(value - 1);
	}
}