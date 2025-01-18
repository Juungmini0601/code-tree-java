import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int n;
	public static int m;
	public static int k;
	public static int[][] arr;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		input();
		int startIndex = k - 1;
		int endIndex = startIndex + m - 1;
		
		for(int row = 0; row < n; row++) {
			if (canShift(row, startIndex, endIndex)) continue;
			// row - 1인 부분에 채우고 탈출
			for(int col = startIndex; col <= endIndex; col++) {
				arr[row-1][col] = 1;
			}

			break;
		}

		printArr();
	}

	public static boolean canShift(int row, int startCol, int endCol) {

		for(int col = startCol; col <= endCol; col++) {
			if(arr[row][col] == 1) {
				return false;
			}
		}

		return true;
	}

	public static void printArr() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
