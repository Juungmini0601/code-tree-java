import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;
	public static int t;

	public static void main(String[] args) throws Exception {
		input();

		for(int time = 0; time < t; time++) {
			// 상단 컨테이너 이동
			int topTemp = arr[0][n-1];
			for(int i = n-1; i > 0; i--) {
				arr[0][i] = arr[0][i-1];
			}
			// 하단 컨테이너 이동
			int bottomTemp = arr[1][n-1];
			for(int i = n-1; i > 0; i--) {
				arr[1][i] = arr[1][i-1];
			}

			arr[0][0] = bottomTemp;
			arr[1][0] = topTemp;
		}

		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[2][n];

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}