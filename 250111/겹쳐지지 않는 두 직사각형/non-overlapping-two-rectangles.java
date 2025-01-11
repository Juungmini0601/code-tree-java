import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;
	public static int m;

	public static void main(String[] args) throws Exception {
		input();
		int maxSum = Integer.MIN_VALUE;

		for (int startX = 1; startX <= n; startX++) {
			for (int startY = 1; startY <= m; startY++) {
				for (int endX = startX; endX <= n; endX++) {
					for (int endY = startY; endY <= m; endY++) {
						int subSquareSum = selectSquare(startX, startY, endX, endY);
						maxSum = Math.max(maxSum, subSquareSum);
					}
				}
			}
		}

		System.out.println(maxSum);
	}

	public static int selectSquare(int startX, int startY, int endX, int endY) {
		boolean[][] visited = new boolean[n + 1][m + 1];
		int sum = 0;

		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				visited[i][j] = true;
				sum += arr[i][j];
			}
		}

		int maxSubSquareSum = Integer.MIN_VALUE;

		for (int startX2 = 1; startX2 <= n; startX2++) {
			for (int startY2 = 1; startY2 <= m; startY2++) {
				for (int endX2 = startX2; endX2 <= n; endX2++) {
					for (int endY2 = startY2; endY2 <= m; endY2++) {
						int subSquareSum = getSum(startX2, endX2, startY2, endY2, visited);
						if (subSquareSum == Integer.MIN_VALUE) {
							continue;
						}

						maxSubSquareSum = Math.max(maxSubSquareSum, subSquareSum);
					}
				}
			}
		}

		return maxSubSquareSum == Integer.MIN_VALUE ? sum : sum + maxSubSquareSum;
	}

	public static int getSum(int startX2, int endX2, int startY2, int endY2, boolean[][] visited) {
		int sum = 0;

		for (int i = startX2; i <= endX2; i++) {
			for (int j = startY2; j <= endY2; j++) {
				if (visited[i][j]) {
					return Integer.MIN_VALUE;
				}
				sum += arr[i][j];
			}
		}

		return sum;
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}