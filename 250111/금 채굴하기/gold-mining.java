import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	// 상 우 하 좌
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int n;
	public static int m;

	// 행복한 수열은 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열이다.
	// 행마다 나오는 n개의 수열과 열마다 나오는 n개의 수열 총 2n 개의 수열이 존재한다.
	// 행복한 수열의 개수를 세시오.
	public static void main(String[] args) throws Exception {
		input();
		final int MAX_K = 2 * n;
		int maxGoldCount = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for(int k = 1; k <= MAX_K; k++) {
					int goldCount = bfsGold(i, j, k);

					// 금을 캤을 때 손해를 안봤다면 최대 값 갱신
					if(m * goldCount >= k * k + (k + 1) * (k + 1)) {
						maxGoldCount = Math.max(maxGoldCount, goldCount);
					}
				}
			}
		}

		System.out.println(maxGoldCount);
	}

	public static int bfsGold(int x, int y, int k) {
		int goldCount = 0;
		Position start = new Position(x, y);
		int[][] distance = new int[n + 1][n + 1];

		Queue<Position> queue = new LinkedList<>();
		distance[x][y] = 1;
		queue.offer(start);

		while (!queue.isEmpty()) {
			Position current = queue.poll();

			if(distance[current.x][current.y] >= k + 1) {
				continue;
			}

			for(int dir = 0; dir < 4; dir++) {
				int nx = current.x + dx[dir];
				int ny = current.y + dy[dir];

				if(nx < 1 || nx > n || ny < 1 || ny > n) {
					continue;
				}

				if(distance[nx][ny] != 0) {
					continue;
				}

				if(arr[nx][ny] == 1) {
					goldCount++;
				}

				distance[nx][ny] = distance[current.x][current.y] + 1;
				queue.offer(new Position(nx, ny));
			}
		}

		return goldCount;
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}