import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static int n, k;

	public static Map<Integer, Integer> map = new HashMap<>();
	public static Scanner sc = new Scanner(System.in);

	static class Number {
		int number;
		int count;

		public Number(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		// Map을 List로 변환
		List<Number> list = new ArrayList<>();
		for (Integer key : map.keySet()) {
			list.add(new Number(key, map.get(key)));
		}

		Collections.sort(list, (a, b) -> {
			if (a.count == b.count) {
				return b.number - a.number;
			}

			return b.count - a.count;
		});

		for (int i = 0; i < k; i++) {
			System.out.print(list.get(i).number + " ");
		}
	}
}
