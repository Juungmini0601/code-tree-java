import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static int n, m;
	public static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			pq.add(sc.nextInt());
		}

		for (int i = 0; i < m; i++) {
			pq.add(pq.poll() - 1);
		}

		System.out.println(pq.poll());
	}
}