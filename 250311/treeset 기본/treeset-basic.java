import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static int n;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			String command = sc.next();

			if (command.equals("add")) {
				int x = sc.nextInt();
				set.add(x);
			} else if (command.equals("remove")) {
				int x = sc.nextInt();
				set.remove(x);
			} else if (command.equals("find")) {
				int x = sc.nextInt();
				String result = set.contains(x) ? "true" : "false";
				System.out.println(result);
			} else if (command.equals("lower_bound")) {
				int x = sc.nextInt();
				Integer val = set.ceiling(x);
				if (val == null) {
					System.out.println("None");
				} else {
					System.out.println(val);
				}
			} else if (command.equals("upper_bound")) {
				int x = sc.nextInt();
				Integer val = set.higher(x);
				if (val == null) {
					System.out.println("None");
				} else {
					System.out.println(val);
				}
			} else if (command.equals("largest")) {
				if (set.isEmpty()) {
					System.out.println("None");
				} else {
					System.out.println(set.last());
				}
			} else if (command.equals("smallest")) {
				if (set.isEmpty()) {
					System.out.println("None");
				} else {
					System.out.println(set.first());
				}
			}
		}
	}
}