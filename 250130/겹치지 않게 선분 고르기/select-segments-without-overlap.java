import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Line {
		int start;
		int end;

		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
	}

	public static int n;
	public static Line[] lines;
	public static Line[] selected;
	public static boolean[] selectedLine;
	public static int ans = 0;
	public static boolean[] visited = new boolean[1001];
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		int end = n;

		while (ans == 0) {
			select(0, end--, 0);
		}

		System.out.println(ans);
	}

	public static void select(int cur, int end, int startIdx) {
		if (cur >= end) {
			boolean condition = fillLine(end);
			Arrays.fill(visited, false);

			if (condition) {
				ans = end;
			}

			return;
		}

		for (int i = startIdx; i < n; i++) {
			if (!selectedLine[i]) {
				selected[cur] = lines[i];
				selectedLine[i] = true;

				select(cur + 1, end, i + 1);

				selectedLine[i] = false;
				selected[cur] = null;
			}
		}
	}

	public static boolean fillLine(int end) {
		for (int i = 0; i < end; i++) {
			Line line = selected[i];

			for (int j = line.start; j <= line.end; j++) {
				if (visited[j]) {
					return false;
				}

				visited[j] = true;
			}
		}

		return true;
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		lines = new Line[n];
		selected = new Line[n];
		selectedLine = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			lines[i] = new Line(start, end);
		}
	}
}