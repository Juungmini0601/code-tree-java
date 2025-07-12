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
			char c = sc.next().charAt(0);
            if(c == 'L') {
                if(it.hasPrevious()) {
                    it.previous();
                }
            } else if(c == 'R') {
                if(it.hasNext()) {
                    it.next();
                }
            } else if(c == 'D') {
                if(it.hasNext()) {
                    it.next();
                    it.remove();
                }
            } else {
                char newC = sc.next().charAt(0);
                it.add(newC);
            }
		}

		for(char c: list) {
			System.out.print(c);
		}
	}
}