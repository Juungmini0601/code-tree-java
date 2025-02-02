import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이용 코드
 */
public class Main {

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}

	public static int n, r, c;
	public static int[][] arr;
	public static int[][] dirs;
	public static int ans = 0;

	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	public static List<Pos> selected = new ArrayList<>();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		Pos start = new Pos(r, c);
		selected.add(start);
		select(start);

		System.out.println(ans);
	}

	public static void select(Pos cur) {
		int dir = dirs[cur.x][cur.y];

		int nx = cur.x;
		int ny = cur.y;

		while (true) {
			nx += dx[dir];
			ny += dy[dir];

			if (!inRange(nx, ny)) {
				ans = Math.max(ans, selected.size() - 1);
				break;
			}
			// 다음 좌표의 값이 현재 좌표의 값보다 크다면 선택
			Pos nextPos = new Pos(nx, ny);
			if (arr[nextPos.x][nextPos.y] > arr[cur.x][cur.y]) {
				selected.add(nextPos);
				select(nextPos);
				selected.remove(selected.size() - 1);
			}
		}
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dirs = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				dirs[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
	}
}
