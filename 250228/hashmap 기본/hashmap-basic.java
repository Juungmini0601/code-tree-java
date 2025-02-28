import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String command = sc.next();

			if (command.equalsIgnoreCase("add")) {
				int k = sc.nextInt();
				int v = sc.nextInt();

				map.put(k, v);
			} else if (command.equalsIgnoreCase("remove")) {
				int k = sc.nextInt();
				map.remove(k);
			} else {
				// find
				int k = sc.nextInt();
				int finded = map.getOrDefault(k, -1);

				if (finded == -1) {
					System.out.println("None");
				} else {
					System.out.println(finded);
				}
			}
		}
	}
}