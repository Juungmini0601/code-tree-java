import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int n;
	public static int m;
	public static int[][] arr;
	public static final int BLANK = 0;

	public static void main(String[] args) throws Exception {
		input();

		for(int i = 0; i < m; i++) {
			int col = Integer.parseInt(br.readLine()) - 1;
			int row = 0;
			// 열의 최상단에서 BLANK가 아닌 첫 row를 찾는다.
			while(row <= n-1 && arr[row][col] == BLANK) row++;

			bomb(row, col);
			shift();
			// printArr();
			// System.out.println();
		}

		printArr();
	}

	public static void shift() {
		int[][] temp = new int[n][n];

		for(int col = 0; col < n; col++) {
			int tempRow = n-1;

			for(int row = n-1; row >= 0; row--) {
				if(arr[row][col] != BLANK) {
					temp[tempRow][col] = arr[row][col];
					tempRow--;
				}
			}
		}

		arr = temp;
	}

	public static void bomb(int row, int col) {
		if(row < 0 || col < 0 || row >= n || col >= n) return;
		int distance = arr[row][col];
		if(distance == 0) return;
		distance--;

		// 행 방향으로 폭발
		int minRow = Math.max(0, row - distance);
		int maxRow = Math.min(n-1, row + distance);

		for(int i = minRow; i <= maxRow; i++) {
			arr[i][col] = 0;
		}

		// 열 방향으로 폭발
		int minCol = Math.max(0, col - distance);
		int maxCol = Math.min(n-1, col + distance);

		for(int i = minCol; i <= maxCol; i++) {
			arr[row][i] = 0;
		}
	}

	public static void printArr() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

