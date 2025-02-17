import java.util.Scanner;

public class Main {

	public static int n;

	static int[][] arr = new int[101][101];
	static int[][] dp = new int[101][101];

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// dp 테이블 채우기
		dp[1][1] = arr[1][1];
		// 1열에 있는 사람들은 왼쪽에서 오는것이 최대 합이다.
		for (int col = 2; col <= n; col++) {
			dp[1][col] = dp[1][col - 1] + arr[1][col];
		}

		//2열 부터는 선택이 가능하다.
		for (int row = 2; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if (col == 1) {
					dp[row][col] = dp[row - 1][col] + arr[row][col];
					continue;
				}
				// 첫 번째 열이 아닌 경우 위쪽에서 오는 값과 왼쪽에서 오는 값 중 최대 값을 고른다.
				dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + arr[row][col];
			}
		}
		
		System.out.println(dp[n][n]);
	}
}