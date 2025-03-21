import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int n;

	public static List<Pos> posList = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);

	static class Pos implements Comparable<Pos>{
		int x;
		int v;

		public Pos(int x, int v) {
			this.x = x;
			this.v = v;
		}

		@Override
		public int compareTo(Pos o) {
			return this.x - o.x;
		}
	}

	public static void main(String[] args) {
		input();
		int ans = 0;
		int cnt = 0;

		for (Pos pos : posList) {
			cnt += pos.v;
			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}

	public static void input() {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			posList.add(new Pos(start, +1));
			posList.add(new Pos(end, -1));
		}

		Collections.sort(posList);
	}
}