import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int n;
	public static int[] values;
	public static int[] dp;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();

		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1];

			for (int curLength = 1; curLength < values.length; curLength++) {
				int value = values[curLength];
				// 현재 길이가 i보다 작을 경우 막대기를 추가 할 수 있음
				if (curLength <= i) {
					dp[i] = Math.max(dp[i], dp[i - curLength] + value);
				}
			}
		}

		int max = Arrays.stream(dp).max().getAsInt();
		System.out.println(max);
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		values = new int[n + 1];
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
	}
}