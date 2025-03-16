import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int v = sc.nextInt();

			if (v != 0) {
				pq.add(v);
				continue;
			}

			if (pq.isEmpty()) {
				System.out.println(0);
				continue;
			}

			System.out.println(pq.poll());
		}
	}
}