import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

	public static Map<Character, Integer> map = new HashMap<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String word = sc.next();

		for (char c : word.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (char c : word.toCharArray()) {
			Integer count = map.getOrDefault(c, 0);
			if (count == 1) {
				System.out.println(c);
				return;
			}
		}

		System.out.println("None");
	}
}