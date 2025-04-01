import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

// N개의 원소로 이루어진 수열이 주어질때 연속하는 K개의 원소들의 합 중 가장 큰 값을 구하시오
public class Main {
	public static int n, q;
	public static HashMap<Integer, Integer> mapper = new HashMap<>();
	public static TreeSet<Integer> ts = new TreeSet<>();

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		q = sc.nextInt();

		for (int i = 0; i < n; i++) {
			ts.add(sc.nextInt());
		}

		for (int i = 1; i <= n; i++) {
			mapper.put(ts.pollFirst(), i);
		}
	}

	public static void main(String[] args) {
		input();

		for (int i = 0; i < q; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(mapper.get(end) - mapper.get(start) + 1);
		}
	}
}