import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static public class Line implements Comparable<Line> {
		int start;
		int end;

		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Line o) {
			return this.start - o.start;
		}
	}

	public static int n;
	public static List<Line> lines = new ArrayList<>();
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		Collections.sort(lines);

		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			// 일단은 현재 선분을 선택한다고 가정한다.
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				// 현재 선분의 시작점이 이전 선분의 끝보다 작거나 같은 경우는 겹치는 경우이므로 선택할 수 없다.
				if (lines.get(i).start <= lines.get(j).end) {
					continue;
				}

				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}

		int ans = Arrays.stream(dp).max().getAsInt();
		System.out.println(ans);
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Line line = new Line(start, end);

			lines.add(line);
		}
	}
}