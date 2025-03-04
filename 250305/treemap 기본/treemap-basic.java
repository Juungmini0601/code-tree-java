import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static int n;
	public static Map<Long, Long> map = new TreeMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String command = sc.next();

			if (command.equals("add")) {
				long k = sc.nextLong();
				long v = sc.nextLong();

				map.put(k, v);
			} else if (command.equals("remove")) {
				long k = sc.nextLong();
				map.remove(k);
			} else if (command.equals("find")) {
				long k = sc.nextLong();
				if (map.containsKey(k)) {
					System.out.println(map.get(k));
				} else {
					System.out.println("None");
				}
			} else if (command.equals("print_list")) {
				if (map.isEmpty()) {
					System.out.println("None");
				} else {
					Iterator<Map.Entry<Long, Long>> iterator = map.entrySet().iterator();
					while (iterator.hasNext()) {
						Map.Entry<Long, Long> entry = iterator.next();
						System.out.print(entry.getValue() + " ");
					}
					System.out.println();
				}
			}
		}
	}
}
