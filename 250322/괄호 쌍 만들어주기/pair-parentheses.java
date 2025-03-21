import java.util.Scanner;

public class Main {

	public static String str;
	public static Scanner sc = new Scanner(System.in);

	// )((()())())
	public static void main(String[] args) {
		input();
		// x[i]는 i + 1부터 끝까지 ))가 몇개있는지?
		int[] x = new int[str.length()];

		for (int i = x.length - 1; i >= 0; i--) {
			// 맨처음에는 연속해서 ))을 셀 수 없으므로 넘긴다.
			if (i + 2 >= str.length())
				continue;

			String temp = str.substring(i + 1, i + 3);
			x[i] = "))".equals(temp) ? x[i + 1] + 1 : x[i + 1];
		}

		int ans = 0;
		for (int i = 0; i < x.length - 1; i++) {
			String temp = str.substring(i, i + 2);
			if ("((".equals(temp)) {
				ans += x[i];
			}
		}

		System.out.println(ans);
	}

	public static void input() {
		str = sc.next();
	}
}