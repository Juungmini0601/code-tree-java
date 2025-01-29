import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int N, M, T;
	static List<int[]> marbles = new ArrayList<>();
	static int[] di = {1, 0, -1, 0}; // D, L, U, R
	static int[] dj = {0, -1, 0, 1};
	static Map<Character, Integer> convert = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		convert.put('D', 0);
		convert.put('L', 1);
		convert.put('U', 2);
		convert.put('R', 3);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			char c = sc.next().charAt(0);
			int d = sc.nextInt();
			marbles.add(new int[] {a, b, convert.get(c), d});
		}

		for (int i = 0; i < T; i++) {
			move();
		}

		int cnt = 0, weight = 0;
		for (int[] m : marbles) {
			if (m.length > 0) {
				cnt++;
				weight = Math.max(weight, m[3]);
			}
		}
		System.out.println(cnt + " " + weight);
	}

	static void move() {
		List<List<List<Integer>>> location = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			location.add(new ArrayList<>());
			for (int j = 0; j < N; j++) {
				location.get(i).add(new ArrayList<>());
			}
		}

		for (int i = 0; i < marbles.size(); i++) {
			int[] m = marbles.get(i);
			if (m.length == 0)
				continue;

			int si = m[0], sj = m[1], d = m[2], w = m[3];
			int ni = si + di[d], nj = sj + dj[d];

			if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
				marbles.set(i, new int[] {ni, nj, d, w});
			} else {
				marbles.set(i, new int[] {si, sj, (d + 2) % 4, w});
			}
			location.get(marbles.get(i)[0]).get(marbles.get(i)[1]).add(i);
		}
		remove(location);
	}

	static void remove(List<List<List<Integer>>> location) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (location.get(i).get(j).size() >= 2) {
					List<Integer> temp = new ArrayList<>(location.get(i).get(j));
					temp.sort(Collections.reverseOrder());

					int val = marbles.get(temp.get(0))[3];
					for (int k = 1; k < temp.size(); k++) {
						val += marbles.get(temp.get(k))[3];
						marbles.set(temp.get(k), new int[0]); // 구슬 제거
					}
					marbles.get(temp.get(0))[3] = val;
				}
			}
		}
	}
}