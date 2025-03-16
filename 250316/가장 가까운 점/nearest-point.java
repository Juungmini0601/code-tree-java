import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static int n, m;
	public static PriorityQueue<Pos> pq = new PriorityQueue<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			pq.add(new Pos(x, y));
		}

		for (int i = 0; i < m; i++) {
			Pos pos = pq.poll();
			Pos newPos = new Pos(pos.x + 2, pos.y + 2);
			pq.add(newPos);
		}

		System.out.println(pq.poll());
	}

	public static class Pos implements Comparable<Pos> {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos o) {
			int sum1 = x + y;
			int sum2 = o.x + o.y;

			if (sum1 != sum2)
				return Integer.compare(sum1, sum2);

			if (this.x != o.x) {
				return Integer.compare(x, o.x);
			}

			return Integer.compare(y, o.y);
		}

		@Override
		public String toString() {
			return String.format("%d %d", x, y);
		}
	}
}
