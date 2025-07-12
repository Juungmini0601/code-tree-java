import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static Scanner scanner = new Scanner(System.in);
	public static int n;
	public static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) {
		n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			String command = scanner.next();
			if (command.equalsIgnoreCase("push_back")) {
				int a = scanner.nextInt();
				list.offerLast(a);
			} else if (command.equalsIgnoreCase("push_front")) {
				int a = scanner.nextInt();
				list.offerFirst(a);
			} else if (command.equalsIgnoreCase("pop_front")) {
				System.out.println(list.pollFirst());
			} else if (command.equalsIgnoreCase("pop_back")) {
				System.out.println(list.pollLast());
			} else if (command.equalsIgnoreCase("size")) {
				System.out.println(list.size());
			} else if (command.equalsIgnoreCase("empty")) {
				System.out.println(list.isEmpty() ? 1 : 0);
			} else if (command.equalsIgnoreCase("front")) {
				System.out.println(list.peekFirst());
			} else if (command.equalsIgnoreCase("back")) {
				System.out.println(list.peekLast());
			}
		}
	}
}