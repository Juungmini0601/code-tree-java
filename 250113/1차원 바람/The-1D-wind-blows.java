import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;
	public static int m;
	public static int q;
	public static final String LEFT = "L";
	public static final String RIGHT = "R";
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();

		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			visited = new boolean[n+1];
			wind(row, dir);
		}

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void wind(int row, String dir) {
		if(row < 1 || row > n) {
			return;
		}
		visited[row] = true;

		// 배열 원소를 오른쪽으로 이동
		if(dir.equals(LEFT)) {
			int temp = arr[row][m];
			for(int i = m; i > 1; i--) {
				arr[row][i] = arr[row][i-1];
			}
			arr[row][1] = temp;
		}
		// 배열 원소를 왼쪽으로 이동
		else {
			int temp = arr[row][1];
			for(int i = 1; i < m; i++) {
				arr[row][i] = arr[row][i+1];
			}
			arr[row][m] = temp;
		}

		// 위쪽으로 갈 수 있다면 전파 시도
		if(checkNextRow(row, row-1) && !visited[row-1]) {
			wind(row-1, convertDir(dir));
		}

		// 아래쪽으로 갈 수 있다면 전파 시도
		if(checkNextRow(row, row+1) && !visited[row+1]) {
			wind(row+1, convertDir(dir));
		}
	}

	public static String convertDir(String dir) {
		if(dir.equals(LEFT)) {
			return RIGHT;
		} else {
			return LEFT;
		}
	}

	public static boolean checkNextRow(int row, int nextRow) {
		if(nextRow < 1 || nextRow > n) {
			return false;
		}

		for(int i = 1; i <= m; i++) {
			if(arr[nextRow][i] == arr[row][i]) {
				return true;
			}
		}

		return false;
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}