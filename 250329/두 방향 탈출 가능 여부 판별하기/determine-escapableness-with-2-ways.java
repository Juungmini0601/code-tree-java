import java.util.Scanner;

// N * M 크기의 이차원 영역의 좌측 상단에서 출발하여 우측 하단까지 뱀에게 물리지 않고 탈출 하려고한다.
// 아래와 오른쪽 두 방향으로 한 칸씩만 이동 할 수 있으며, 뱀이 없어야 한다.
// 뱀에게 물리지 않고 탈출 가능한 경로가 있는지 판별하는 코드를 작성하시오
public class Main {

	public static int n, m;
	public static int[][] grid;
	public static boolean[][] visited;
	// 아래 오른쪽
	public static int[] dx = {1, 0};
	public static int[] dy = {0, 1};

	public static final int SNAKE = 0;

	public static Scanner sc = new Scanner(System.in);

	public static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
	}

	public static boolean canGo(int x, int y) {
		if (x < 1 || x > n || y < 1 || y > m) {
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

	public static void dfs(int x, int y) {
		for (int dir = 0; dir < 2; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (canGo(nx, ny)) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

	public static void main(String[] args) {
		init();
		visited[1][1] = true;
		dfs(1, 1);

		System.out.println(visited[n][m] ? 1 : 0);
	}
}