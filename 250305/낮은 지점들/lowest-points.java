import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static int n;
	public static Map<Long, Long> map = new HashMap<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();

			map.put(x, Math.min(map.getOrDefault(x, Long.MAX_VALUE), y));
		}

		Long sum = map.values().stream().reduce((a, b) -> a + b).get();
		System.out.println(sum);
	}
}