import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 코테 풀이용 코드
public class Main {

	public static int n;
	public static int m;
	public static int t;
	public static int[][] arr;
	public static int[][] marbles;
	public static int[][] nextMarbles;
	// 상 하 좌 우
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();

		for(int i = 1; i <= t; i++) {
			simulate();
		}

		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(marbles[i][j] == 1) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

	private static void simulate() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(marbles[i][j] == 1) {
					move(i, j);
				}
			}
		}

		copyMarbles();
		nextMarbles = new int[n+1][n+1];
	}

	private static void copyMarbles() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(nextMarbles[i][j] >= 2) {
					marbles[i][j] = 0;
				}
				else if(nextMarbles[i][j] <= 1) {
					marbles[i][j] = nextMarbles[i][j];
				}
			}
		}
	}

	private static void move(int x, int y) {
		Pos nextPos = getNextPos(x, y);
		nextMarbles[nextPos.x][nextPos.y] += 1;
	}

	private static Pos getNextPos(int x, int y) {
		Pos pos = null;
		int maxValue = Integer.MIN_VALUE;

		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if(nx < 1 || nx > n || ny < 1 || ny > n) {
				continue;
			}

			if(arr[nx][ny] > maxValue) {
				pos = new Pos(nx, ny);
				maxValue = arr[nx][ny];
			}
		}

		return pos;
	}


	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		arr = new int[n+1][n+1];
		marbles = new int[n+1][n+1];
		nextMarbles = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for( int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			marbles[r][c] = 1;
		}
	}
}

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
