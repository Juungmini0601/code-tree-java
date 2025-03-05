import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static int n;
	public static Map<Integer, Integer> map = new TreeMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int num = sc.nextInt();
			if (map.containsKey(num))
				continue;

			map.put(num, i);
		}

		for (Integer num : map.keySet()) {
			System.out.printf("%d %d\n", num, map.get(num));
		}
	}
}