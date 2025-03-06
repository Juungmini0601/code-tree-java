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
			String command = sc.next();

			if (command.equalsIgnoreCase("add")) {
				int x = sc.nextInt();
				set.add(x);
			} else if (command.equalsIgnoreCase("remove")) {
				int x = sc.nextInt();

				set.remove(x);
			} else {
				int x = sc.nextInt();

				if (set.contains(x)) {
					System.out.println("true");
				} else {
					System.out.println("false");
				}
			}
		}
	}
}