import java.util.Scanner;

public class Main {
	public static long s;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		s = sc.nextLong();
	}

	// 합이 S이하인 경우 중 N의 최대 값
	// 합이 S보다 큰 경우 중 최소값 -1해주면 될 듯
	public static long search() {
		long left = 1;                          
        long right = 2 * s;                     
        long maxNum = 0;   

		while (left <= right) {
			long mid = (left + right) / 2;
			long tempSum = mid * (mid + 1) / 2;

			if (tempSum <= s) {
				left = mid + 1;
				minValue = Math.max(minValue, mid);
			} else {
				right = mid -1;
			}
		}

		return minValue;
	}

	public static void main(String[] args) {
		input();
		long value = search();
		System.out.println(value);
	}
}