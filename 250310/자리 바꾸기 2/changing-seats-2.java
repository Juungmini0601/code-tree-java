import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static int n, k;
	public static int[][] swaps;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();

		swaps = new int[k + 1][2];
		for (int i = 1; i <= k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			swaps[i][0] = a;
			swaps[i][1] = b;
		}

		int[] seats = new int[n + 1];
		Set<Integer>[] sets = new Set[n + 1];

		for (int i = 1; i <= n; i++) {
			sets[i] = new HashSet<>();
			seats[i] = i;

			sets[i].add(i);
		}

		for (int i = 1; i <= 3 * k; i++) {
			int index = i;

			if (index >= 2 * k + 1) {
				index -= 2 * k;
			} else if (index >= k + 1) {
				index -= k;
			}

			int a = swaps[index][0];
			int b = swaps[index][1];

			int temp = seats[a];
			seats[a] = seats[b];
			seats[b] = temp;

			sets[seats[a]].add(a);
			sets[seats[b]].add(b);
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(sets[i].size());
		}
	}

	private static void print(int[] arr) {
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}