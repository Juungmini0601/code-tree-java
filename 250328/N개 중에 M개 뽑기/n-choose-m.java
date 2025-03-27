import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int n, m;
	public static List<Integer> selected = new ArrayList<>();

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
	}

	public static void print() {
		for (int i : selected) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void choice(int cur) {
		if (cur > m) {
			print();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (cur == 1) {
				selected.add(i);
				choice(cur + 1);
				selected.remove(selected.size() - 1);
			} else {
				if (i > selected.get(selected.size() - 1)) {
					selected.add(i);
					choice(cur + 1);
					selected.remove(selected.size() - 1);
				}
			}

		}
	}

	public static void main(String[] args) {
		input();
		choice(1);
	}
}