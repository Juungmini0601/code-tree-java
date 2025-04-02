import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 일직선 위에 N개의 구간이 주어졌을 때 구간이 가장 많이 겹치는 부분에서 몇개의 구간이 겹치는가
public class Main {

	public static int n;
	public static TreeSet<Pos> posTs = new TreeSet<>();
	public static Set<Integer> set = new HashSet<>();

	static class Pos implements Comparable<Pos> {
		int x;
		int v;
		int index;

		public Pos(int x, int v, int index) {
			this.x = x;
			this.v = v;
			this.index = index;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.x, o.x);
		}
	}

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			Pos startP = new Pos(start, 1, i);
			Pos endP = new Pos(end, -1, i);

			posTs.add(startP);
			posTs.add(endP);
		}
	}

	public static void solve() {
		int ans = 0;

		for (Pos pos : posTs) {
			if (pos.v == 1) {
				if (set.isEmpty()) {
					ans++;
				}

				set.add(pos.index);
			} else {
				set.remove(pos.index);
			}
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) {
		input();
		solve();
	}
}