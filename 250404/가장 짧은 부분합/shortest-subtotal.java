import java.util.Scanner;

public class Main {

	public static int n, s;
	public static int[] arr;

	public static Scanner sc = new Scanner(System.in);

	public static void init() {
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
	}

	public static void solve() {
		int curSum = 0;
		int right = -1;
		int ans = Integer.MAX_VALUE;

		for (int left = 0; left < n; left++) {
			while (curSum < s && right + 1 < n) {
				curSum += arr[right + 1];
				right++;
			}

			if (curSum < s) {
				break;
			}

			ans = Math.min(ans, right - left + 1);

			curSum -= arr[left];
		}

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	public static void main(String[] args) {
		init();
		solve();
	}
}