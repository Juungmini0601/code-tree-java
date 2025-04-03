import java.util.Scanner;

public class Main {

	public static String str;
	public static int[] a;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		str = sc.nextLine();
		a = new int[str.length()];

		for (int i = str.length() - 1; i >= 0; i--) {
			if (i == str.length() - 1) {
				continue;
			}

			String sub = str.substring(i, i + 2);
			if ("))".equals(sub)) {
				a[i] = a[i + 1] + 1;
			} else {
				a[i] = a[i + 1];
			}
		}
	}

	public static void solve() {
		int cnt = 0;
		for (int i = 1; i < a.length; i++) {
			String sub = str.substring(i - 1, i + 1);
			if ("((".equals(sub)) {
				if (i + 1 < a.length) {
					cnt += a[i + 1];
				}
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		input();
		solve();
	}
}