import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;

	public static void main(String[] args) throws Exception {
		input();

		int maxCoin = 0;

		for(int i = 1; i <= n-2; i++) {
			for(int j = 1; j <= n-2; j++) {
				maxCoin = Math.max(maxCoin, countCoin(i, j));
			}
		}

		System.out.println(maxCoin);
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static int countCoin(int row, int col) {
		int cnt = 0;

		for(int i = row; i <= row + 2; i++) {
			for(int j = col; j <= col + 2; j++) {
				cnt += arr[i][j];
			}
		}

		return cnt;
	}
}