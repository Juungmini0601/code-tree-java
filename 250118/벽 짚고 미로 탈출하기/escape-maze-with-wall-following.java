import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int n;
	public static int x;
	public static int y;
	public static final int WALL = 1;
	public static final int EMPTY = 0;
	// 우측 상측 좌측 하측
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {1, 0, -1, 0};
	public static int[][] arr;
	public static boolean[][][] visited;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		input();
		// 0 = 우측, 1 = 위쪽, 2 = 왼쪽, 3 = 아래쪽
		int dir = 0;
		int time = 0;
		visited[dir][x][y] = true;

		while (inRange(x, y)) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			// 탈출 할 수 있는 경우이므로 옮겨주고 패스
			if (!inRange(nx, ny)) {
				x = nx;
				y = ny;
				time++;
				break;
			}

			// 여기서부터는 모두 다음 칸이 격자위에 존재하는 경우
			// 다음칸으로 이동을 할 수 있을때
			if (arr[nx][ny] == EMPTY) {

				// 이미 방문했던 경우라면 앞으로도 싸이클을 돌것이다.
				if (visited[dir][nx][ny]) {
					System.out.println(-1);
					return;
				}

				// 이동 했을 때 벽이 있다면 이동한다.
				if (isWall(dir, nx, ny)) {
					x = nx;
					y = ny;
					visited[dir][x][y] = true;
					time++;
				}
				else {
					x = nx;
					y = ny;
					visited[dir][x][y] = true;
					time++;
					dir = rotateRight(dir);
					visited[dir][nx][ny] = true;
					nx = x + dx[dir];
					ny = y + dy[dir];
					x = nx;
					y = ny;
					visited[dir][nx][ny] = true;
					time++;
				}
			}
			// 다음 칸으로 이동할 수 없다면 회전후 한 칸 이동한다.
			else {
				dir = rotateLeft(dir);
			}
		}

		System.out.println(time);
		// printArr();
	}


	public static boolean isWall(int dir, int nx, int ny) {
		// 0 = 우측, 1 = 위쪽, 2 = 왼쪽, 3 = 아래쪽
		if (dir == 0) {
			return arr[nx + 1][ny] == WALL;
		} else if (dir == 1) {
			return arr[nx][ny + 1] == WALL;
		} else if (dir == 2) {
			return arr[nx - 1][ny] == WALL;
		} else {
			return arr[nx][ny-1] == WALL;
		}
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	// 시계 방향이동
	// 0 = 우측, 1 = 위쪽, 2 = 왼쪽, 3 = 아래쪽
	public static int rotateRight(int dir) {
		if (dir == 3) {
			return 2;
		}

		if(dir == 2) {
			return 1;
		}

		if(dir == 1) {
			return 0;
		}

		return 3;
	}

	// 반시계 방향이동
	// 0 = 우측, 1 = 위쪽, 2 = 왼쪽, 3 = 아래쪽
	public static int rotateLeft(int dir) {
		if (dir == 3) {
			return 0;
		}

		if(dir == 2) {
			return 3;
		}

		if(dir == 1) {
			return 2;
		}

		return 1;
	}

	public static void printArr() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()) - 1;
		y = Integer.parseInt(st.nextToken()) - 1;
		arr = new int[n][n];
		visited = new boolean[4][n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) == '.' ? 0 : 1;
			}
		}
	}
}
