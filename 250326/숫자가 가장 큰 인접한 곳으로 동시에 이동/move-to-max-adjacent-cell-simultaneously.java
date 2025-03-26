import java.util.Scanner;

public class Main {

	public static final int MAX_N = 20;
	// 상하좌우
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static int[][] nextGrid = new int[MAX_N + 1][MAX_N + 1];
	public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];

	public static int n, m, t;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < m; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			nextGrid[r][c] = 1;
		}
	}

	public static boolean inRange(int r, int c) {
		return r >= 1 && r <= n && c >= 1 && c <= n;
	}

	public static void simulate() {
		int[][] temp = new int[MAX_N + 1][MAX_N + 1];

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if (nextGrid[r][c] == 0)
					continue;

				int nr = r;
				int nc = c;

				for (int dir = 0; dir < 4; dir++) {
					int tr = r + dx[dir];
					int tc = c + dy[dir];

					if (inRange(tr, tc) && grid[tr][tc] > grid[nr][nc]) {
						nr = tr;
						nc = tc;
					}
				}

				temp[nr][nc]++;
			}
		}

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if (temp[r][c] == 1)
					nextGrid[r][c] = temp[r][c];
				else
					nextGrid[r][c] = 0;
			}
		}
	}

	public static void main(String[] args) {
		input();

		for (int i = 0; i < t; i++) {
			simulate();
		}

		int cnt = 0;

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if (nextGrid[r][c] == 1)
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}