import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int n, m;
	public static final int MAX_N = 20;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList<Integer> numbers = new ArrayList<>();
	public static ArrayList<Integer>[][] map = new ArrayList[MAX_N][MAX_N];

	public static void main(String[] args) throws Exception {
		init();

		for (int number : numbers) {
			Position pos = findPosition(number);

			Position maxPosition = null;
			int maxValue = Integer.MIN_VALUE;

			// 8개 자리를 탐색하면서 maxPosition의 위치를 찾는다.
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i == 0 && j == 0) {
						continue;
					}

					int nx = pos.x + i;
					int ny = pos.y + j;

					if (nx < 1 || nx > n || ny < 1 || ny > n)
						continue;

					int max = findMaxNumberIn(map[nx][ny]);
					if (max == Integer.MIN_VALUE)
						continue;

					if (max > maxValue) {
						maxValue = max;
						maxPosition = new Position(nx, ny);
					}
				}
			}

			if (maxPosition != null) {
				move(pos, maxPosition, number);
			}
		}

		printMap();
	}

	private static void printMap() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j].isEmpty()) {
					System.out.println("None");
				} else {
					for (int number : map[i][j]) {
						System.out.print(number + " ");
					}
					System.out.println();
				}
			}
		}
	}

	public static void move(Position from, Position to, int number) {
		ArrayList<Integer> fromList = map[from.x][from.y];
		ArrayList<Integer> toList = map[to.x][to.y];
		int startIndex = fromList.indexOf(number);

		for (int i = startIndex; i >= 0; i--) {
			toList.add(0, fromList.remove(i));
		}
	}

	public static int findMaxNumberIn(ArrayList<Integer> list) {
		int max = Integer.MIN_VALUE;
		for (int number : list) {
			if (number > max) {
				max = number;
			}
		}

		return max;
	}

	public static Position findPosition(int number) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j].contains(number)) {
					return new Position(i, j);
				}
			}
		}

		throw new RuntimeException("not Found Number");
	}

	public static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				map[i][j].add(Integer.parseInt(st.nextToken()));
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
	}

}