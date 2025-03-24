import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		long s = sc.nextLong();
		long left = 0;
		long right = s;
		long answer = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = mid * (mid + 1) / 2;

			if (sum > s) {
				right = mid - 1;
			} else {
				answer = mid;
				left = mid + 1;
			}
		}

		System.out.println(answer);
	}
}
