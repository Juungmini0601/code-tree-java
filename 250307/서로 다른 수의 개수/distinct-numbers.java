import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static int n;
	public static Set<Integer> set = new HashSet<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			set.add(sc.nextInt());
		}

		System.out.println(set.size());
	}
}