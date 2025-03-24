import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static long s;

	public static void main(String[] args) {
		s = sc.nextLong();
		long left = 0;
		long right =  s;
		long min = Long.MIN_VALUE;
		// sum >= s 보다 작거나 같은 값중 최대 값을 찾기
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = (mid + 1) * mid / 2;

			if (sum > s) {
				right = mid - 1;
			} else {
				left = mid + 1;
				min = Math.max(min, mid);
			}
		}

		System.out.println(min);
	}
}

