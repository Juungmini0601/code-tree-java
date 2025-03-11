import java.util.Scanner;
import java.util.TreeSet;

class Pos implements Comparable<Pos> {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pos o) {
		if (this.x == o.x) {
			return this.y - o.y;
		}

		return this.x - o.x;
	}

	@Override
	public String toString() {
		return this.x + " " + this.y;
	}
}

public class Main {

	public static int n, m;
	public static TreeSet<Pos> ts = new TreeSet<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			Pos pos = new Pos(x, y);
			ts.add(pos);
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			Pos pos = new Pos(x, y);

			Pos find = ts.ceiling(pos);
			if (find == null) {
				System.out.println("-1 -1");
			} else {
				System.out.println(find);
			}
		}
	}
}