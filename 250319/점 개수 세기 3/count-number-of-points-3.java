import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 수직선 상의 서로 다른 위치에 N개의 점이 주어진다.
 * Q개의 질의에 대해 구간 내 점의 개수를 출력해라
 *
 * [a, b]를 만족하는 위치에 있는 점의 개수를 세어야 한다.
 */
public class Main {

	public static int n, q;
	public static int[] arr;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		q = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			ts.add(arr[i]);
		}
		// 원소의 값을 압축하여 순서대로 할 거임
		int cnt = 1;
		HashMap<Integer, Integer> mapper = new HashMap<>();

		for (int num: ts) {
			mapper.put(num, cnt++);
		}

		for (int i = 0; i < q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(mapper.get(b) - mapper.get(a) + 1);
		}
	}
}