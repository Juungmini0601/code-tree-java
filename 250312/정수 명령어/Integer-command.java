import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static int t;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			solve();
		}
	}

	public static void solve() {
		TreeSet<Integer> ts = new TreeSet<>();
		int k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			String word = sc.next();

			if (word.equalsIgnoreCase("i")) {
				int n = sc.nextInt();
				ts.add(n);
			} else if (word.equalsIgnoreCase("d")) {
				int val = sc.nextInt();

				if (ts.isEmpty()) {
					continue;
				}

				if (val == 1) {
					ts.pollLast();
				} else if (val == -1) {
					ts.pollFirst();
				}
			}
		}

		if (ts.isEmpty()) {
			System.out.println("EMPTY");
			return;
		}

		System.out.printf("%d %d\n", ts.last(), ts.first());
	}
}