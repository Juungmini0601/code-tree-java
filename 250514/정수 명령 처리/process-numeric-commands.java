import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static int n;

	public static void main(String[] args) {
		n = sc.nextInt();

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if (command.equalsIgnoreCase("push")) {
				int x = sc.nextInt();
				stack.addLast(x);
			} else if (command.equalsIgnoreCase("pop")) {
				System.out.println(stack.pollLast());
			} else if (command.equalsIgnoreCase("size")) {
				System.out.println(stack.size());
			} else if (command.equalsIgnoreCase("empty")) {
				System.out.println(stack.isEmpty() ? 1 : 0);
			} else if (command.equalsIgnoreCase("top")) {
				System.out.println(stack.peekLast());
			}
		}
	}
}