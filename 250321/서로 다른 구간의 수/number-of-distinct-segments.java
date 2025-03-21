import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int n;
	public static List<Pos> posList = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);

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
			return this.x - o.x;
		}
	}

	public static void main(String[] args) {
		input();
		Collections.sort(posList);

		HashSet<Integer> set = new HashSet<>();
		int count = 0;

		for (Pos pos : posList) {
			// 시작점일 때 
			if (pos.v == 1) {
				// set에 아무런 선분도 없다면 카운트를 증가한다.
				if (set.isEmpty()) {
					count++;
				}

				set.add(pos.index);
			} else if (pos.v == -1) {
				// 끝 점일때
				set.remove(pos.index);
			}
		}

		System.out.println(count);
	}

	public static void input() {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			posList.add(new Pos(start, 1, i));
			posList.add(new Pos(end, -1, i));
		}
	}
}