import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static Deque<Integer> dq = new ArrayDeque<>();

	public static void main(String[] args) {
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if (command.equalsIgnoreCase("push_front")) {
				int a = sc.nextInt();
				dq.addFirst(a);
			} else if (command.equalsIgnoreCase("push_back")) {
				int a = sc.nextInt();
				dq.addLast(a);
			} else if (command.equalsIgnoreCase("pop_front")) {
				System.out.println(dq.pollFirst());
			} else if (command.equalsIgnoreCase("pop_back")) {
				System.out.println(dq.pollLast());
			} else if (command.equalsIgnoreCase("size")) {
				System.out.println(dq.size());
			} else if (command.equalsIgnoreCase("empty")) {
				System.out.println(dq.isEmpty() ? 1 : 0);
			} else if (command.equalsIgnoreCase("front")) {
				System.out.println(dq.peekFirst());
			} else if (command.equalsIgnoreCase("back")) {
				System.out.println(dq.peekLast());
			}
		}
	}
}