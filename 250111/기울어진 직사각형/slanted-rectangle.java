import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;

	public static void main(String[] args) throws Exception {
		input();

		int maxSum = 0;

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				maxSum = Math.max(maxSum, getSumSquare(i, j));
			}
		}

		System.out.println(maxSum);
	}

	public static int getSumSquare(int i, int j) {
		int sum = 0;

		for(int width = 1; width <= n; width++) {
			for(int height = 1; height <= n; height++) {
				sum = Math.max(getSum(i, j, width, height), sum);
			}
		}

		return sum;
	}

	public static int getSum(int i, int j, int width, int height) {
		int curX = i;
		int curY = j;
		int sum = 0;
		sum += arr[curX][curY];

		// 1번 방향으로 이동
		for(int k = 0; k < width; k++) {
			curX--;
			curY++;

			if(curX < 1 || curY > n) {
				return -1;
			}

			sum += arr[curX][curY];
		}
		// 2번 방향으로 이동
		for(int k = 0; k < height; k++) {
			curX--;
			curY--;

			if(curX < 1 || curY < 1) {
				return -1;
			}

			sum += arr[curX][curY];
		}
		// 3번 방향으로 이동
		for(int k = 0; k < width; k++) {
			curX++;
			curY--;

			if(curX > n || curY < 1) {
				return -1;
			}

			sum += arr[curX][curY];
		}
		// 4번 방향으로 이동
		for(int k = 0; k < height-1; k++) {
			curX++;
			curY++;

			if(curX > n || curY > n) {
				return -1;
			}

			sum += arr[curX][curY];
		}

		return sum;
	}


	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}