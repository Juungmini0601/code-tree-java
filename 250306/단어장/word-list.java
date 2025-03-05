import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static int n;
	public static Map<String, Integer> wordMap = new TreeMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String word = sc.next();
			wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
		}

		for (String word : wordMap.keySet()) {
			System.out.printf("%s %d\n", word, wordMap.get(word));
		}
	}
}