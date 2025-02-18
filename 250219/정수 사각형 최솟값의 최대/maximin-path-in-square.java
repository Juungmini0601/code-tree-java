import java.util.Scanner;

public class Main {

	public static int n;
	public static int[][] arr;
	// dp[i][j]는 i,j까지 오기의 숫자들 중 최소 값의 최대 값
	public static int[][] dp;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();
		dp[1][1] = arr[1][1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				// 1층일 경우에는 왼쪽 값을 비교해서 최소 값을 적어준다.
				if (i == 1) {
					dp[i][j] = Math.min(dp[i][j - 1], arr[i][j]);
					continue;
				}

				// 2층부터는 위쪽 값과 왼쪽 값을 같이 비교해야한다.
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				dp[i][j] = Math.min(dp[i][j], arr[i][j]);
			}
		}

		System.out.println(dp[n][n]);
	}

	public static void input() {
		n = sc.nextInt();
		arr = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}
}