import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int n;
	public static boolean[] visited;
	public static List<Integer> selected = new ArrayList<>();

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		visited = new boolean[n + 1];
	}

	public static void print() {
		for (int i : selected) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void choice(int cur) {
		if (cur == n + 1) {
			print();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected.add(i);
				choice(cur + 1);
				selected.remove(selected.size() - 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		input();
		choice(1);
	}
}