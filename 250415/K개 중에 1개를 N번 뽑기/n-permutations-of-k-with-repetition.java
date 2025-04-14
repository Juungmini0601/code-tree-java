import java.util.Scanner;

/**
 * @author    : kimjungmin
 * Created on : 2025. 4. 15.
 */
public class Main {

	public static int n, k;

	public static int[] selected;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		k = sc.nextInt();

		selected = new int[k];
	}

	public static void printSelected() {
		for (int i = 0; i < k; i++) {
			System.out.print(selected[i] + " ");
		}

		System.out.println();
	}

	public static void select(int cur) {
		if (cur >= k) {
			printSelected();
			return;
		}

		for (int i = 1; i <= n; i++) {
			selected[cur] = i;
			select(cur + 1);
		}
	}

	public static void solve() {
		select(0);
	}

	public static void main(String[] args) {
		input();
		solve();
	}
}
