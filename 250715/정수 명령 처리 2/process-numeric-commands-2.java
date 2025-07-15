import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static Queue<Integer> q = new LinkedList<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if (command.equalsIgnoreCase("push")) {
				int a = sc.nextInt();
				q.add(a);
			} else if (command.equalsIgnoreCase("pop")) {
				System.out.println(q.poll());
			} else if (command.equalsIgnoreCase("size")) {
				System.out.println(q.size());
			} else if (command.equalsIgnoreCase("empty")) {
				System.out.println(q.isEmpty() ? 1 : 0);
			} else if (command.equalsIgnoreCase("front")) {
				System.out.println(q.peek());
			}
		}
	}
}