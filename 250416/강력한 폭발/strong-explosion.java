import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static int n;
	public static int[][] arr;
	public static int bombCnt = 0;
	public static int ans = 0;

	public static List<Integer> bombs = new ArrayList<>();
	public static List<Pos> positions = new ArrayList<>();

	public static int[][] dx = {
		{0, 0, 0, 0, 0},
		{-2, -1, 0, 1, 2},// 1
		{-1, 0, 0, 1, 0}, // 2
		{-1, -1, 0, 1, 1} // 3
	};

	public static int[][] dy = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}, // 1
		{0, 1, 0, 0, -1},// 2
		{-1, 1, 0, 1, -1}// 3
	};

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				// 폭탄 위치 수집
				if (arr[i][j] == 1) {
					positions.add(new Pos(i, j));
				}
			}
		}

		bombCnt = positions.size();
	}

	public static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	public static int bomb() {
		int cnt = 0;
		boolean[][] visited = new boolean[n][n];

		for (int i = 0; i < bombCnt; i++) {
			Pos pos = positions.get(i);
			int bomb = bombs.get(i);

			for (int dir = 0; dir < 5; dir++) {
				int nx = pos.x + dx[bomb][dir];
				int ny = pos.y + dy[bomb][dir];

				if (!inRange(nx, ny) || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				cnt++;
			}
		}

		return cnt;
	}

	public static void select(int cur) {
		if (cur >= bombCnt) {
			ans = Math.max(ans, bomb());
			return;
		}

		for (int i = 1; i <= 3; i++) {
			bombs.add(i);
			select(cur + 1);
			bombs.remove(cur);
		}
	}

	public static void solve() {
		select(0);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		input();
		solve();
	}
}
