import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0, 1로만 이루어진 N * N 격자가 있다.
 * K개의 벽을 없애서 이동하여 도착점까지 가려고 한다.
 * 숫자 0은 이동하는 곳이고 숫자 1은 벽이 있는 곳이다.
 * 
 * dist[r][c][k] => (r, c)에 벽을 K번 부스고 도달한 거리
 */
public class Main {

	public static int n, k;
	public static int[][] map;
	public static int[][][] dist;
	public static int r1, c1, r2, c2;
	// 상 우 하 좌
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static final int WALL = 1;

	public static class Pos {
		int x, y, k;

		public Pos(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		BFS();

		int temp = Integer.MAX_VALUE;

		for (int i = 0; i <= k; i++) {
			if (dist[r2][c2][i] != 0) {
				temp = Math.min(temp, dist[r2][c2][i]);
			}
		}

		System.out.println(temp == Integer.MAX_VALUE ? -1 : temp - 1);
	}

	public static void BFS() {
		Pos start = new Pos(r1, c1, 0);
		dist[r1][c1][0] = 1;

		Queue<Pos> q = new ArrayDeque<>();
		q.offer(start);

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				// 출발 위치는 제외한다.
				if (nx == r1 && ny == c1)
					continue;

				if (!inRange(nx, ny))
					continue;

				if (map[nx][ny] == WALL) {
					// 현재 위치에서 벽을 k번 이상 부수지 않았다면 갈 수 있는것
					if (cur.k < k) {
						if (dist[nx][ny][cur.k + 1] == 0) {
							dist[nx][ny][cur.k + 1] = dist[cur.x][cur.y][cur.k] + 1;
							q.offer(new Pos(nx, ny, cur.k + 1));
						}
					}
				}
				// 벽이 아니라면 걍 갈 수 있음 방문 안했다는 전재 하에
				else {
					if (dist[nx][ny][cur.k] == 0) {
						dist[nx][ny][cur.k] = dist[cur.x][cur.y][cur.k] + 1;
						q.offer(new Pos(nx, ny, cur.k));
					}
				}
			}
		}
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		dist = new int[n][n][k + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken()) - 1;
		c1 = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		r2 = Integer.parseInt(st.nextToken()) - 1;
		c2 = Integer.parseInt(st.nextToken()) - 1;
	}
}
