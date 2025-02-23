import java.util.Scanner;

public class Main {

	public static int n;
	public static int m;
	public static int[][] arr;
	public static int[][] dp;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
		dp[0][0] = 1; // 시작점의 점프 횟수 정의

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				find(i, j); // 점프 가능한 지점들 계산
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) { // 최대 점프 횟수 계산
			for (int j = 0; j < m; j++) {
				ans = Math.max(ans, dp[i][j]);
			}
		}

		System.out.println(ans);
	}

	public static void find(int row, int col) {
		for (int i = row + 1; i < n; i++) {  // 아래쪽 방향 점프
			for (int j = col + 1; j < m; j++) {  // 오른쪽 방향 점프
				if (arr[row][col] < arr[i][j]) {  // 현재 값보다 커야 점프 가능
					dp[i][j] = Math.max(dp[i][j], dp[row][col] + 1);  // dp 갱신
				}
			}
		}
	}

	public static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}
}

