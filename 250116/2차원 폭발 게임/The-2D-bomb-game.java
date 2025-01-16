import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int n;
	public static int m;
	public static int k;
	public static int[][] arr;
	public static final int BLANK = 0;

	public static void main(String[] args) throws Exception{
		input();

		for(int i = 0; i < k; i++) {
			// 회전하기 전에 모든 폭탄을 터트린다.
			while (bomb()) {
				shift();
			}

			rotate();
			shift();
			// 회전 후 모든 폭탄을 터트린다.
			while (bomb()) {
				shift();
			}
		}

		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] != BLANK) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

	public static void rotate() {
		int[][] temp = new int[n][n];

		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				temp[col][n-1-row] = arr[row][col];
			}
		}

		arr = temp;
	}

	public static void shift() {
		int[][] temp = new int[n][n];

		for(int col = 0; col < n; col++) {
			int tempIndex = n - 1;
			for(int row = n-1; row >= 0; row--) {
				if(arr[row][col] != BLANK) {
					temp[tempIndex][col] = arr[row][col];
					tempIndex--;
				}
			}
		}

		arr = temp;
	}

	// 전체 배열에서 행 기준으로 원소가 연속해서 m개 이상이 존재할 경우 폭탄을 터트린다.
	public static boolean bomb() {
		boolean isBombed = false;

		for(int col = 0; col < n; col++) {
			for(int row = 0; row < n; row++) {
				if (arr[row][col] == BLANK) {
					continue;
				}

				int endIndex = findEndIndex(row, col);
				// m개 이상 연속하다면 폭탄으로 마스크한다.
				if (endIndex - row + 1 >= m) {
					markBlank(row, endIndex, col);
					isBombed = true;
				}
			}
		}

		return isBombed;
	}

	public static void markBlank(int startRow, int endRow, int col) {
		for(int i = startRow; i <= endRow; i++) {
			arr[i][col] = BLANK;
		}
	}

	public static int findEndIndex(int startRow, int col) {
		int data = arr[startRow][col];

		if(data == BLANK) {
			throw new RuntimeException("findEndIndex Invalid Data Call BLANK");
		}

		for(int row = startRow + 1; row < n; row++) {
			if(arr[row][col] != data) {
				return row - 1;
			}
		}

		return n - 1;
	}


	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void printArr() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

