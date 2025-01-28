import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static class Marble {
		int x;
		int y;
		int dir;

		public Marble(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static int t, n, m;
	// 좌:0, 상:1 하 2, 우:3
	public static int[] dx = {0, -1, 1, 0};
	public static int[] dy = {-1, 0, 0, 1};
	public static final int MAX_N = 50;
	public static int[][] marbleArea;
	public static Map<String, Integer> mapper = new HashMap<>()
		;
	public static List<Marble> marbles;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		mapper.put("L", 0);
		mapper.put("U", 1);
		mapper.put("D", 2);
		mapper.put("R", 3);

		for (int i = 0; i < t; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			marbleArea = new int[MAX_N + 1][MAX_N + 1];
			marbles = new ArrayList<>();

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				String dir = st.nextToken();

				marbles.add(new Marble(x, y, mapper.get(dir)));
				marbleArea[x][y] = 1;
			}

			for (int j = 0; j <= 2 * n; j++) {
				simulate();
			}

			System.out.println(marbles.size());
		}
	}

	private static void printMarbleArea() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(marbleArea[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void simulate() {
		move(); // 1. 구슬을 먼저 움직인다.
		removeDuplicatedMarble(); // 2. marbleArea의 값이 2이상인 원소를 지운다.
	}

	// 구슬 배열에서 구슬을 뽑아서 배열을 이동시킨다.
	public static void move() {
		for (int i = 0; i < marbles.size(); i++) {
			Marble marble = marbles.get(i);
			int nx = marble.x + dx[marble.dir];
			int ny = marble.y + dy[marble.dir];

			// 구슬이 범위 안에 있으면 이전 구슬의 위치를 제거하고 이동시킨다.
			if (inRange(nx, ny)) {
				Marble nextMarble = new Marble(nx, ny, marble.dir);
				marbles.set(i, nextMarble);

				marbleArea[nx][ny]++;
				marbleArea[marble.x][marble.y]--;
			}
			// TODO 구슬이 범위 안에 없다면 구슬의 방향을 바꾼다.
			else {
				Marble nextMarble = new Marble(marble.x, marble.y, 3 - marble.dir);
				marbles.set(i, nextMarble);
			}
		}
	}

	// 여기서 안들어가네 구슬이 그지?
	public static void removeDuplicatedMarble() {
		ArrayList<Marble> nextMarbles = new ArrayList<>();

		// 지워야될 구슬을 미리 빼둔다. 여기서 좌표를 수정하면 뒤에서 빼야 할 구슬이 들어갈 수 있다.
		for (Marble marble : marbles) {
			if (marbleArea[marble.x][marble.y] > 1) {
				continue;
			}
			nextMarbles.add(marble);
		}

		// 구슬을 다 빼놨으니까 자리 업데이트 쳐준다.
		for (Marble marble : marbles) {
			if (marbleArea[marble.x][marble.y] > 1) {
				marbleArea[marble.x][marble.y] = 0;
			}
		}

		marbles = nextMarbles;
	}

	public static boolean inRange(int x, int y) {
		return 1 <= x && x <= n && 1 <= y && y <= n;
	}
}