import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static int n, m;
	public static Map<Integer, Integer> map = new HashMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int key = sc.nextInt();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		for (int i = 0; i < m; i++) {
			int key = sc.nextInt();
			System.out.print(map.getOrDefault(key, 0) + " ");
		}
	}
}