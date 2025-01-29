import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[] selected = new int[10];
	public static int[][] arr;
	public static int[][] newArr;
	public static int n;
	public static int selectMax;
	public static int maxMarkCnt;

	public static List<Position> positions;
	public static final int BOMB = 1;
	public static final int EMPTY = 0;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[][] dx = {
		{0, 0, 0, 0, 0}, // 0번은 그냥 무시
		{-2, -1, 0, 1, 2},// 1번 타입
		{-1, 0, 0, 0, 1}, // 2번 타입
		{-1, -1, 0, 1, 1} // 3번타입
	};

	public static int[][] dy = {
		{0, 0, 0, 0, 0}, // 0번은 그냥 무시
		{0, 0, 0, 0, 0}, // 1번 타입
		{0, -1, 0, 1, 0}, // 2번 타입
		{-1, 1, 0, -1, 1} // 3번 타입
	};

	public static void main(String[] args) throws Exception {
		input();
		select(0);
		System.out.println(maxMarkCnt);
	}

	public static void select(int cur) {
		if (cur == selectMax) {
			int markCnt = bomb();
			maxMarkCnt = Math.max(maxMarkCnt, markCnt);
			return;
		}

		for (int i = 1; i <= 3; i++) {
			selected[cur] = i;
			select(cur + 1);
		}
	}

	public static int bomb() {
		int markCnt = 0;

		for (int index = 0; index < positions.size(); index++) {
			int bombType = selected[index];
			Position position = positions.get(index);

			for (int dir = 0; dir < 5; dir++) {
				int nx = position.x + dx[bombType][dir];
				int ny = position.y + dy[bombType][dir];

				if (!inRange(nx, ny))
					continue;
				if (newArr[nx][ny] == EMPTY) {
					markCnt++;
					newArr[nx][ny] = BOMB;
				}
			}
		}

		cleanNewArr();

		return markCnt;
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void cleanNewArr() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newArr[i][j] = EMPTY;
			}
		}
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		newArr = new int[n][n];
		positions = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				arr[i][j] = v;

				if (v == BOMB) {
					positions.add(new Position(i, j));
				}
			}
		}

		selectMax = positions.size();
	}
}