import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int n;
	public static int r;
	public static int c;
	public static int[][] arr;
	// 상 하 좌 우
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		input();
		int curR = r;
		int curC = c;
		System.out.print(arr[curR][curC] + " ");

		while (true) {
			int curValue = arr[curR][curC];
			boolean findNext = false;

			for(int dir = 0; dir < 4; dir++) {
				int nextX = curR + dx[dir];
				int nextY = curC + dy[dir];

				if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

				if (arr[nextX][nextY] > curValue) {
					curR = nextX;
					curC = nextY;
					System.out.print(arr[curR][curC] + " ");
					findNext = true;
					break;
				}
			}

			if (!findNext) break;
		}
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

