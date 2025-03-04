import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static int n;
	public static Map<String, Integer> map = new HashMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();

		int max = 0;

		for (int i = 0; i < n; i++) {
			String str = sc.next();

			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String sorted = String.valueOf(arr);

			map.put(sorted, map.getOrDefault(sorted, 0) + 1);
			max = Math.max(map.get(sorted), max);
		}

		System.out.println(max);
	}
}
