import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static String input;

	public static void main(String[] args) {
		input = sc.next();
		ArrayDeque<Character> stack = new ArrayDeque<>();

		for (char c : input.toCharArray()) {
			if (c == '(') {
				stack.addLast(c);
				continue;
			}

			if (stack.isEmpty()) {
				System.out.println("No");
				return;
			}

			stack.pollLast();
		}

		if (stack.isEmpty()) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}