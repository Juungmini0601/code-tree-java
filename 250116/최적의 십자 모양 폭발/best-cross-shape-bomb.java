import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int n;
	public static int[][] arr;
	public static final int BLANK = 0;

	public static void main(String[] args) throws Exception {
		input();
		int maxCount = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int count = bombAndCount(i, j);
				maxCount = Math.max(count, maxCount);
			}
		}

		System.out.println(maxCount);
	}

	public static int bombAndCount(int row, int col) {
		int[][] copy = copyArr();
		int distance = copy[row][col] - 1;

		int minRow = Math.max(row - distance, 0);
		int maxRow = Math.min(n-1, row + distance);

		for(int r = minRow; r <= maxRow; r++) {
			copy[r][col] = BLANK;
		}

		int minCol = Math.max(col - distance, 0);
		int maxCol = Math.min(col + distance, n - 1);

		for(int c = minCol; c <= maxCol; c++) {
			copy[row][c] = BLANK;
		}

		// shift
		int[][] temp = new int[n][n];

		for(int c = 0; c < n; c++) {
			int tempRowIndex = n-1;

			for(int r = n-1; r >= 0; r--) {
				if(copy[r][c] != BLANK) {
					temp[tempRowIndex][c] = copy[r][c];
					tempRowIndex--;
				}
			}
		}

		copy = temp;
		int cnt = 0;

		// 가로 방향으로 세기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1; j++) {
				if(copy[i][j] == copy[i][j+1] && copy[i][j] != BLANK) {
					cnt++;
				}
			}
		}

		// 세로 방향으로 세기
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n; j++) {
				if(copy[i][j] == copy[i+1][j] && copy[i][j] != BLANK) {
					cnt++;
				}
			}
		}

		// printArr(copy);
		// System.out.println(cnt);
		// System.out.println();

		return cnt;
	}

	public static void printArr(int[][] arr) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] copyArr() {
		int[][] copy = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = arr[i][j];
			}
		}

		return copy;
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

