import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int k, n;
	public static List<Integer> selected = new ArrayList<>();

	public static Scanner sc = new Scanner(System.in);

	public static void printSelected() {
		for (int i = 0; i < selected.size(); i++) {
			System.out.print(selected.get(i) + " ");
		}
		System.out.println();
	}

	public static void choice(int cur) {
		if (cur == n) {
			printSelected();
			return;
		}

		for (int i = 1; i <= k; i++) {
			if (cur < 2) {
				selected.add(i);
				choice(cur + 1);
				selected.remove(selected.size() - 1);
				continue;
			}

			int num1 = selected.get(selected.size() - 1);
			int num2 = selected.get(selected.size() - 2);

			if (!(num1 == num2 && num2 == i)) {
				selected.add(i);
				choice(cur + 1);
				selected.remove(selected.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		k = sc.nextInt();
		n = sc.nextInt();
		choice(0);
	}
}