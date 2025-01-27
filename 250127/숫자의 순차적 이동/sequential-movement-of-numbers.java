import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 코테 풀이용 코드
public class Main {

	public static int n;
	public static int m;
	public static int[][] arr;


	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();

		for(int i = 1; i <= m; i++) {
			simulate();
		}

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void simulate() {
		for(int num = 1; num <= n * n; num++) {
			Pos numPos = findPos(num);
			Pos maxPos = findMaxPos(numPos);

			int temp = arr[numPos.x][numPos.y];
			arr[numPos.x][numPos.y] = arr[maxPos.x][maxPos.y];
			arr[maxPos.x][maxPos.y] = temp;
		}
	}

	private static Pos findMaxPos(Pos numPos) {
		int maxValue = Integer.MIN_VALUE;
		int maxX = 0;
		int maxY = 0;

		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				int nx = numPos.x + i;
				int ny = numPos.y + j;

				if(nx < 1 || nx > n || ny < 1 || ny > n) {
					continue;
				}

				if(i == 0 && j == 0) {
					continue;
				}

				if(arr[nx][ny] > maxValue) {
					maxValue = arr[nx][ny];
					maxX = nx;
					maxY = ny;
				}
			}
		}

		return new Pos(maxX, maxY);
	}

	private static Pos findPos(int num) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(arr[i][j] == num) {
					return new Pos(i, j);
				}
			}
		}

		return null;
	}

	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for( int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
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
