import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이용 코드
 */
public class Main {

	public static int n, m;
	public static int[] arr;
	public static int[] selected;
	public static int ans = 0;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		combination(0, 0);
		System.out.println(ans);
	}

	public static void combination(int cur, int cnt) {
		if (cur == n || cnt == m) {
			if (cnt == m) {
				// 최대값 계산 시작
				int temp = selected[0];
				for (int i = 1; i < m; i++) {
					temp ^= selected[i];
				}

				ans = Math.max(ans, temp);
			}
			return;
		}
		// 현재 숫자를 뽑지 않은 경우
		combination(cur + 1, cnt);
		// 현재 숫자를 뽑은 경우
		selected[cnt] = arr[cur];
		combination(cur + 1, cnt + 1);
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m];
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
