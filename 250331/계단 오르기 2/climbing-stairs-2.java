import java.util.Arrays;
import java.util.Scanner;

// N층 높이의 계단
// 계단은 1계단 혹은 2계단 올라 갈 수 있음, 1계단 오르는 행동은 최대 3번만 할 수 있음
// 계단에는 동전이 있음
// 올라가면서 얻을수 있는 최대 동전 개수를 구하고자함
// dp[i][j] <- i번째 1번오르기를 j번 했을 때 동전을 얻은 최대 개수
public class Main {

	public static int n;
	public static int[] arr;
	public static int[][] dp;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		arr = new int[n + 1];
		dp = new int[n + 1][4];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
	}

	public static void solve() {
		dp[1][1] = arr[1];

		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				// 짝수 번째 계단인 경우 2 4 6 8 ... dp[2][0], dp[2][1] X, dp[2][2]
				// dp[4][0] dp[4][1] X, dp[4][2], dp[4][3] X
				// 짝수 번째 계단은 한번 점프를 0 2만 가능하네?
				dp[i][0] = dp[i - 2][0] + arr[i];
				dp[i][2] = Math.max(dp[i - 1][1], dp[i - 2][2]) + arr[i];
			} else {
				// 홀수번째 계단은 j가 1 3일때만 유효하다.
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][1]) + arr[i];
				dp[i][3] = Math.max(dp[i - 1][2], dp[i - 2][3]) + arr[i];
			}
		}
	}

	public static void main(String[] args) {
		input();
		solve();

		// for (int i = 0; i < dp.length; i++) {
		// 	System.out.println(i + "번째 계단:" + Arrays.toString(dp[i]));
		// }

		System.out.println(Arrays.stream(dp[n]).max().getAsInt());
	}
}