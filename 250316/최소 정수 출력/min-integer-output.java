import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static int n;
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int val = sc.nextInt();

			if (val == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.add(val);
			}
		}
	}
}