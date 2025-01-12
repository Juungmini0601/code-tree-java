import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;
	public static int m;

	public static void main(String[] args) throws Exception {
		input();

		int ans = -1;

		for(int startX = 1; startX <= n; startX++) {
			for(int startY = 1; startY <= m; startY++) {
				for(int endX = startX; endX <= n; endX++) {
					for(int endY = startY; endY <= m; endY++) {
						if (positiveSquare(startX, startY, endX, endY)) {
							ans = Math.max(ans, (endX - startX + 1) * (endY - startY + 1));
						}
					}
				}
			}
		}

		System.out.println(ans);
	}

	public static boolean positiveSquare(int startX, int startY, int endX, int endY) {
		for(int i = startX; i <= endX; i++) {
			for(int j = startY; j <= endY; j++) {
				if(arr[i][j] <= 0) {
					return false;
				}
			}
		}

		return true;
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}