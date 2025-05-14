import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static int n;
	public static Scanner sc = new Scanner(System.in);
	public static Deque<Integer> dq = new ArrayDeque<>();

	public static void main(String[] args) {
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			dq.addLast(i);
		}

		while (dq.size() > 1) {
			dq.pollFirst();
			dq.addLast(dq.pollFirst());
		}

		System.out.println(dq.peekLast());
	}
}