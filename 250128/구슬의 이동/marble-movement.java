import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Marble {
		int index;
		int x;
		int y;
		int d;
		int v;

		public Marble(int index, int x, int y, int d, int v) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.d = d;
			this.v = v;
		}
	}

	public static int n, m, t, k;
	public static int[][] marbleMap;
	public static List<Marble> marbles;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 0 왼쪽 1 위쪽 2 아래쪽 3오른쪽
	// 방향전환을하고 있으면 3 - dir
	public static int[] dx = {0, -1, 1, 0};
	public static int[] dy = {-1, 0, 0, 1};
	public static Map<String, Integer> mapper = new HashMap<>();

	public static void main(String[] args) throws Exception {
		input();

		for (int i = 0; i < t; i++) {
			simulate();
		}

		System.out.println(marbles.size());
	}

	public static void printArr() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(marbleMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void simulate() {
		move();
		removeDuplicatedMarbles();
	}

	public static void removeDuplicatedMarbles() {
		// marbles를 보면서 map에 marble이 몇개 있는지 표시한다.
		marbles.forEach(marble -> marbleMap[marble.x][marble.y]++);

		// TODO 삭제
		// System.out.println(t + " 초 [움직이기 후]");
		// printArr();

		// k개보다 작거나 같은 위치가 있는 곳이 있다면 해당 구슬은 살아 남는다.
		List<Marble> nextMarbles = new ArrayList<>();
		Map<String, PriorityQueue<Marble>> removeMarbleMap = new HashMap<>();

		for (Marble marble : marbles) {
			// 여기서 바로 수정하면 버그가 생길 가능성이 있음
			if (marbleMap[marble.x][marble.y] <= k) {
				nextMarbles.add(marble);
			} else {
				String key = marble.x + " " + marble.y;
				if (!removeMarbleMap.containsKey(key)) {
					removeMarbleMap.put(key, new PriorityQueue<>((a, b) -> Integer.compare(a.index, b.index)));
				}

				removeMarbleMap.get(key).add(marble);
			}
		}

		// map의 모든 key에 대해서 큐의 원소가 k이상이면 구슬을 제거한다.
		for (String key : removeMarbleMap.keySet()) {
			PriorityQueue<Marble> pq = removeMarbleMap.get(key);

			while (pq.size() > k) {
				pq.poll();
			}
		}

		// 남은 구슬을 모두 새로운 구슬주머니에 넣는다.
		for (String key : removeMarbleMap.keySet()) {
			PriorityQueue<Marble> pq = removeMarbleMap.get(key);

			while (!pq.isEmpty()) {
				nextMarbles.add(pq.poll());
			}
		}

		marbles = nextMarbles;
		marbleMap = new int[n + 1][n + 1];
	}

	public static void move() {
		ArrayList<Marble> nextMarbles = new ArrayList<>();

		for (Marble marble : marbles) {
			int nx = marble.x + dx[marble.d] * marble.v;
			int ny = marble.y + dy[marble.d] * marble.v;

			if (inRange(nx, ny)) {
				nextMarbles.add(new Marble(marble.index, nx, ny, marble.d, marble.v));
			} else {
				// 방향에 따라서 좌표 값이 바뀔 수 있음.
				int[] pos = changePosition(marble.x, marble.y, marble.d, marble.v);
				nextMarbles.add(new Marble(marble.index, pos[0], pos[1], 3 - marble.d, marble.v));
			}
		}

		marbles = nextMarbles;
	}

	// TODO 충돌이 여러번 일어 날 수 있음.
	public static int[] changePosition(int x, int y, int dir, int v) {
		int[] ret = {x, y};

		for (int i = 0; i < v; i++) {
			int nx = ret[0] + dx[dir];
			int ny = ret[1] + dy[dir];

			if (inRange(nx, ny)) {
				ret[0] = nx;
				ret[1] = ny;
			} else {
				// 왼쪽으로 가는 중
				if (dir == 0) {
					ret[0] = nx;
					ret[1] = 2;
				}
				// 위쪽으로 가는중
				else if (dir == 1) {
					ret[0] = 2;
					ret[1] = ny;
				}
				// 아래쪽으로 가는중
				else if (dir == 2) {
					ret[0] = n - 1;
					ret[1] = ny;
				}
				// 오른쪽으로 가는중
				else {
					ret[0] = nx;
					ret[1] = n - 1;
				}
				dir = 3 - dir;
			}
		}

		return ret;
	}

	public static boolean inRange(int x, int y) {
		return 1 <= x && x <= n && 1 <= y && y <= n;
	}

	public static void input() throws Exception {
		mapper.put("L", 0);
		mapper.put("U", 1);
		mapper.put("D", 2);
		mapper.put("R", 3);

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		marbles = new ArrayList<>();
		marbleMap = new int[n + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			int v = Integer.parseInt(st.nextToken());

			marbles.add(new Marble(i, x, y, mapper.get(dir), v));
		}
	}
}