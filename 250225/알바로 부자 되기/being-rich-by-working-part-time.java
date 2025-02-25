import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 알바를 적당히 골라서 돈을 제일 많이 버는 방법을 찾아보자.
 * Work (start, end, pay)
 * dp[i] = i번째 알바를 마지막으로 했을 때 벌 수 있는 최대 금액
 */
public class Main {

	public static class Work implements Comparable<Work> {
		int start;
		int end;
		int pay;

		public Work(int start, int end, int pay) {
			this.start = start;
			this.end = end;
			this.pay = pay;
		}

		@Override
		public int compareTo(Work o) {
			return this.start - o.start;
		}
	}

	public static int n;
	public static int[] dp;
	public static Work[] works;
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		Arrays.sort(works);

		for (int i = 0; i < n; i++) {
			dp[i] = works[i].pay;

			for (int j = 0; j < i; j++) {
				// 현재 작업의 시작일이 이전 작업의 끝나는 일보다 작거나 같으면 고를 수 없다.
				if (works[i].start <= works[j].end) {
					continue;
				}

				dp[i] = Math.max(dp[i], dp[j] + works[i].pay);
			}
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new int[n];
		works = new Work[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());

			works[i] = new Work(start, end, pay);
		}
	}
}