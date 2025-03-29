import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// N * M 크기의 이차원 영역의 좌측 상단에서 출발하여 우측 하단까지 뱀에게 물리지 않고 탈출 하고 싶다.
// 이동은 상 하 좌 우 인접한 칸으로 만 갈 수 있으며 뱀이 있는 칸으로는 이동하지 않는다.
// 뱀에게 물리지 않고 탈출 가능한 경로가 있는가?
public class Main {
	public static int n, m;
	public static int[][] grid;
	public static boolean[][] visited;
	public static final int SNAKE = 0;

	public static Queue<Pos> queue = new LinkedList<>();

	// 상 하 좌 우
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static Scanner sc = new Scanner(System.in);

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
	}

	public static boolean canGo(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}

		if (grid[x][y] == SNAKE) {
			return false;
		}

		if (visited[x][y]) {
			return false;
		}

		return true;
	}

	public static void bfs() {
		Pos start = new Pos(0, 0);
		visited[0][0] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			Pos pos = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if (canGo(nx, ny)) {
					visited[nx][ny] = true;
					queue.add(new Pos(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) {
		init();
		bfs();

		System.out.println(visited[n - 1][m - 1] ? 1 : 0);
	}
}