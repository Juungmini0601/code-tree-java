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
			dp[i][0] = dp[i - 2][0] + arr[i];

			for (int j = 1; j <= 3; j++) {
				// 1번 점프를 했을때, 안했을 때 중 최대 값을 찾아서 더해주기
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 2][j]) + arr[i];
			}
		}
	}

	public static void main(String[] args) {
		input();
		solve();
		System.out.println(Arrays.stream(dp[n]).max().getAsInt());
	}
}