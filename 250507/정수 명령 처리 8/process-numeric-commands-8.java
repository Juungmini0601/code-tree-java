import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			String command = sc.next();
			// Please write your code here.
			if (command.equals("push_front")) {
				int a = sc.nextInt();
				list.addFirst(a);
			} else if (command.equals("push_back")) {
				int a = sc.nextInt();
				list.addLast(a);
			} else if (command.equals("pop_front")) {
				System.out.println(list.pollFirst());
			} else if (command.equals("pop_back")) {
				System.out.println(list.pollLast());
			} else if (command.equals("size")) {
				System.out.println(list.size());
			} else if (command.equals("empty")) {
				System.out.println(list.isEmpty() ? 1 : 0);
			} else if (command.equals("front")) {
				System.out.println(list.peekFirst());
			} else if (command.equals("back")) {
				System.out.println(list.peekLast());
			}
		}
	}
}