import java.util.Scanner;

public class Main {

	public static final int MAX_N = 100;
	// 상하좌우
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];

	public static int n, r, c;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
	}

	public static boolean inRange(int r, int c) {
		return r >= 1 && r <= n && c >= 1 && c <= n;
	}

	public static void simulate() {
		while (inRange(r, c)) {
			System.out.print(grid[r][c] + " ");

			boolean changed = false;

			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dx[dir];
				int nc = c + dy[dir];

				if (inRange(nr, nc) && grid[nr][nc] > grid[r][c]) {
					r = nr;
					c = nc;
					changed = true;
					break;
				}
			}

			if (!changed) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		input();
		simulate();
	}
}