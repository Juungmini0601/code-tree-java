import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int k, n;
	public static List<Integer> selected = new ArrayList<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		k = sc.nextInt();
		n = sc.nextInt();

		choice(1);
	}

	public static void choice(int cur) {
		if (cur >= n + 1) {
			for (int i = 0; i < selected.size(); i++) {
				System.out.print(selected.get(i) + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= k; i++) {
			selected.add(i);
			choice(cur + 1);
			selected.remove(selected.size() - 1);
		}
	}
}