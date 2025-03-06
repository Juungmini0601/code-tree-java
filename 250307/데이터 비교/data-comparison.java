import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static int n1, n2;
	public static Set<Integer> set = new HashSet<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n1 = sc.nextInt();

		for (int i = 0; i < n1; i++) {
			set.add(sc.nextInt());
		}

		n2 = sc.nextInt();
		for (int i = 0; i < n2; i++) {
			int num = sc.nextInt();

			if (set.contains(num)) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}
	}
}