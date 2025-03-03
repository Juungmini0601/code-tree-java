import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * N개의 문자열이 주어진다.
 * 각 문자열은 1 ~ N까지 주어진 순서대로 정수와 대응 된다.
 * M개의 정수 혹은 문자열이 주어졌을때 정수에 대해서는 대응되는 문자열을 문자열에 대해서는 대응되는 정수를 출력하라.
 */

public class Main {
	public static int n, m;
	public static Map<String, Integer> strIntegerMap = new HashMap<>();
	public static Map<Integer, String> integerStrMap = new HashMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			String str = sc.next();
			strIntegerMap.put(str, i);
			integerStrMap.put(i, str);
		}

		for (int i = 0; i < m; i++) {
			String key = sc.next();

			if (strIntegerMap.containsKey(key)) {
				System.out.println(strIntegerMap.get(key));
			} else {
				System.out.println(integerStrMap.get(Integer.parseInt(key)));
			}
		}
	}
}