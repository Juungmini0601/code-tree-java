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
			char c = scanner.next().charAt(0);
            if(c == 'L') {
                if(iterator.hasPrevious()) {
                    iterator.previous();
                }
            } else if(c == 'R') {
                if(iterator.hasNext()) {
                    iterator.next();
                }
            } else if(c == 'D') {
                if(iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
            } else {
                char newC = scanner.next().charAt(0);
                iterator.add(newC);
            }
		}

		for(char c: list) {
			System.out.print(c);
		}
	}
}