import java.util.Scanner;

public class Main {

	public static int n, m;
	public static int[] arr;
	public static int max = Integer.MIN_VALUE;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
	}

	public static void search() {
		int left = 1;
		int right = 2 * max;
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			// 같은 크기의 정수 count 개 <- M개 이상이어야함
			int count = countNumber(mid);
			if (count < m) {
				right = mid - 1;
			} else {
				left = mid + 1;
				answer = Math.max(answer, mid);
			}
		}

		System.out.println(answer);
	}

	public static int countNumber(int target) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			count += arr[i] / target;
		}
		return count;
	}

	public static void main(String[] args) {
		input();
		search();
	}
}