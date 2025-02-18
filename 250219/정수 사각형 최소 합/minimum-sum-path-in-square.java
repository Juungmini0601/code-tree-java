import java.util.Scanner;

public class Main {

	public static int n;
	public static int[][] arr;
	public static int[][] dp;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();

		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= 1; j--) {
				// 1층일 때는 오른쪽에서 만 올 수 있으니까.
				if (i == 1) {
					if (j == n) {
						dp[i][j] = arr[i][j];
					} else {
						dp[i][j] = dp[i][j + 1] + arr[i][j];
					}
				}
				// 2층부터는 위쪽과 오른쪽에서 올 수 있음
				else {
					// 우측 끝이라면 위에서만 올 수 있음
					if (j == n) {
						dp[i][j] = dp[i - 1][j] + arr[i][j];
					} else {
						// 우측과 위쪽 값중 최소 값을 경로로 선택한다.
						dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + arr[i][j];
					}
				}
			}
		}
		
		System.out.println(dp[n][1]);
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