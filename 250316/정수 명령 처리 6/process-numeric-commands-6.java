import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if (command.equals("push")) {
				int a = sc.nextInt();
				pq.add(a);
			} else if (command.equals("pop")) {
				System.out.println(pq.poll());
			} else if (command.equals("size")) {
				System.out.println(pq.size());
			} else if (command.equals("empty")) {
				System.out.println(pq.isEmpty() ? "1" : "0");
			} else if (command.equals("top")) {
				System.out.println(pq.peek());
			}
		}
	}
}