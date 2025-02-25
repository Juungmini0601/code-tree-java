import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가 감소 부분 수열 구하기
 * N: 1~1000 자연수, 원소의 숫자
 * 원소: 1 ~ 10000 자연수
 *
 * 풀이 전략: dp
 * dp[i][0]: i번째 원소를 마지막으로 하는 가장 긴 증가 하는 부분 수열
 * dp[i][1]: i번째 원소를 마지막으로 하면서 가장 긴 증가 감소 부분수열(최초에 증가 했다가 한 번만 감소함)
 * dp[i][2]: i번째 원소를 마지막으로 하면서 가장 긴 감소 하는 부분수열
 */
public class Main {

	public static int n;
	public static int[] arr;
	public static int[][] dp;

	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();

		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
			dp[i][1] = 1;
			dp[i][2] = 1;

			int curValue = arr[i];

			for (int j = 0; j < i; j++) {
				int beforeValue = arr[j];
				// 값이 같은 경우는 의미가 없다.
				if (curValue == beforeValue)
					continue;
				// 이전 값이 현재 값보다 작은 경우
				if (beforeValue < curValue) {
					// 현재 숫자가 포함된다면 증가하는 부분 수열이다.
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
					continue;
				}
				// 이전 값이 현재 값보다 큰 경우
				// 증가 - 감소에서 감소를 시작하는 부분이다.
				dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
				// 증가 - 감소를 이어 가고 있을 수 있다.
				dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
				// 감소하는 부분수열이다.
				dp[i][2] = Math.max(dp[i][2], dp[j][2] + 1);
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i][0]);
			ans = Math.max(ans, dp[i][1]);
			ans = Math.max(ans, dp[i][2]);
		}

		System.out.println(ans);
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n][3];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}