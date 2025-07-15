import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static Queue<Integer> q = new LinkedList<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();

		// 입력
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while (q.size() >= 1) {
			for (int i = 0; i < k - 1; i++) {
				q.add(q.poll());
			}
			
			int x = q.poll();
			System.out.print(x + " ");
		}
	}
}