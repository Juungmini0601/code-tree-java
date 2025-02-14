import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/** 
 * 숫자 0, 1, 2, 3으로만 이루어진 N * N 격자에 사람이 H명 겹치지 않게 서있다.
 * 비를 피할 수 있는 공간의 위치는 M개가 주어진다.
 * 각 사람마다 비를 피할 수 있는 가장 가까운 공간까지의 거리를 구하려고한다.
 *
 * 숫자 1은 벽이다.
 * 숫자 2는 해당 칸에 사람이 서 있음을 의미한다.
 * 숫자 3은 해당 공간이 비를 피할 수 있는 공간임을 의미한다.
 * 사람은 상하좌우 인접한 곳으로만 움직일 수 있으며, 벽이 아닌 곳은 전부 이동 가능하다.
 */
public class Main {

	public static int n, h, m;
	public static int[][] map;
	public static int[][] answerMap;
	public static int[][] dist;
	public static Pos[] startPositions;

	// 상 우 하 좌
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static final int WALL = 1;
	public static final int HUMAN = 2;
	public static final int GOAL = 3;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		answerMap = copyMap();

		for (int i = 0; i < h; i++) {
			Pos startPosition = startPositions[i];
			BFS(startPosition);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (map[i][j] != HUMAN) {
					System.out.print(0 + " ");
				} else {
					int value = answerMap[i][j] == -1 ? -1 : answerMap[i][j] - 1;
					System.out.print(value + " ");
				}
			}
			System.out.println();
		}
	}

	public static void BFS(Pos startPosition) {
		int[][] newMap = copyMap();
		dist = new int[n][n];

		Queue<Pos> q = new ArrayDeque<>();
		q.offer(startPosition);
		dist[startPosition.x][startPosition.y] = 1;

		while (!q.isEmpty()) {
			Pos current = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = current.x + dx[dir];
				int ny = current.y + dy[dir];

				if (nx == startPosition.x && ny == startPosition.y)
					continue;

				if (!inRange(nx, ny))
					continue;

				if (newMap[nx][ny] == WALL)
					continue;

				if (dist[nx][ny] != 0)
					continue;

				dist[nx][ny] = dist[current.x][current.y] + 1;
				q.offer(new Pos(nx, ny));
				// 비를 피하는 곳에 도착하면 표시 후 종료
				if (newMap[nx][ny] == GOAL) {
					answerMap[startPosition.x][startPosition.y] = dist[nx][ny];
					return;
				}
			}
		}

		// 여기까지 왔다는 거는 도달하지 못한다는 뜻
		answerMap[startPosition.x][startPosition.y] = -1;
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static int[][] copyMap() {
		int[][] copy = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = map[i][j];
			}
		}

		return copy;
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int humanIndex = 0;
		startPositions = new Pos[h];

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == HUMAN) {
					startPositions[humanIndex] = new Pos(i, j);
					humanIndex++;
				}
			}
		}
	}
}
