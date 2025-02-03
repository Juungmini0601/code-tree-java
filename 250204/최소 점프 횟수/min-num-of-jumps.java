import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이용 코드
 */
public class Main {

	public static int n;
	public static int[] arr;
	public static int ans = -1;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		jump(0, 0);

		System.out.println(ans);
	}

	public static void jump(int cur, int cnt) {
		if (cur >= n - 1) {
			if (ans == -1 || ans > cnt) {
				ans = cnt;
			}
			return;
		}

		int number = arr[cur];
		for (int i = 1; i <= number; i++) {
			jump(cur + i, cnt + 1);
		}
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
