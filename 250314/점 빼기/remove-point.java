// 2차원 평면에 서로 다른 N개의 점이 주어진다.
// M개의 질의가 주어지며 각 질의 마다 한개의 수 k가 주어진다.

// 각 질의에 대해 주어진 수 k보다 x값이 같거나 큰 점중 x값이 가장 작은 점을 찾아 지우려고한다.
// 만일 x값이 가장 작은 점이 여러 개면 y값이 가장 작은 점을 지우면 된다.

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
		if (x == o.x) {
			return y - o.y;
		}

		return x - o.x;
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

			ts.add(new Pos(x, y));
		}

		for (int i = 0; i < m; i++) {
			int k = sc.nextInt();
			Pos find = ts.ceiling(new Pos(k, 0));

			if (find == null) {
				System.out.println("-1 -1");
			} else {
				System.out.println(find.x + " " + find.y);
				ts.remove(find);
			}
		}
	}
}