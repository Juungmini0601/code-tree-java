import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	public static LinkedList<Character> list = new LinkedList<>();
	public static int n, m;
	public static String s;


	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		s = scanner.next();
		scanner.nextLine();

		for(char c: s.toCharArray()) {
			list.add(c);
		}

		ListIterator<Character> iterator = list.listIterator(list.size());

		for(int i = 0; i < m; i++) {
			String command = scanner.nextLine();
			if (command.charAt(0) == 'L') {
				if (iterator.hasPrevious()) iterator.previous();
			} else if (command.charAt(0) == 'R') {
				if (iterator.hasNext()) iterator.next();
			} else if (command.charAt(0) == 'D') {
				if (iterator.hasNext()) {
					iterator.next();
					iterator.remove();
				}
			} else {
				char c = command.split(" ")[1].charAt(0);
				iterator.add(c);
			}
		}

		for(char c: list) {
			System.out.print(c);
		}
	}
}