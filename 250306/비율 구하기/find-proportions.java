import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static int n;
	public static Map<String, Integer> map = new TreeMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String word = sc.next();
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		for (String word : map.keySet()) {
			Integer count = map.getOrDefault(word, 0);

			double ratio = (double) count / n * 100;
			System.out.printf("%s %.4f\n", word, x);
		}
	}
}