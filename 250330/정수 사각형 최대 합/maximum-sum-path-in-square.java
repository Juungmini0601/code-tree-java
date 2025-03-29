import java.util.Scanner;

public class Main {

	public static int n;
	public static int[][] grid;
	public static int[][] dp;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		grid = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
	}

	public static void main(String[] args) {
		input();
		// dp 테이블 초기화
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]) + grid[row][col];
			}
		}

		System.out.println(dp[n][n]);
	}
}