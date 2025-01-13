import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;
	public static int m;
	public static int q;
	// 자기 자신, 상 우 하 좌
	public static int[] dx = {0, -1, 0, 1, 0};
	public static int[] dy = {0, 0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		input();

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int startRow = Integer.parseInt(st.nextToken());
			int startCol = Integer.parseInt(st.nextToken());
			int endRow = Integer.parseInt(st.nextToken());
			int endCol = Integer.parseInt(st.nextToken());
			wind(startRow, startCol, endRow, endCol);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void wind(int startRow, int startCol, int endRow, int endCol) {
		// 상단 경계를 오른쪽으로 이동
		int temp1 = arr[startRow][endCol];
		for (int i = endCol; i >= startCol + 1; i--) {
			arr[startRow][i] = arr[startRow][i - 1];
		}
		// 우측 경계를 아래쪽으로 이동
		int temp2 = arr[endRow][endCol];
		for (int i = endRow; i >= startRow + 1; i--) {
			arr[i][endCol] = arr[i - 1][endCol];
		}
		// 하단 경계를 왼쪽으로 이동
		int temp3 = arr[endRow][startCol];
		for(int i = startCol; i <= endCol - 1; i++) {
			arr[endRow][i] = arr[endRow][i + 1];
		}
		// 좌측 경계를 위쪽으로 이동
		int temp4 = arr[startRow][startCol];
		for(int i = startRow; i <= endRow - 1; i++) {
			arr[i][startCol] = arr[i + 1][startCol];
		}

		arr[startRow + 1][endCol] = temp1;
		arr[endRow][endCol-1] = temp2;
		arr[endRow-1][startCol] = temp3;
		arr[startRow][startCol+1] = temp4;

		// 2차언 배열 copy
		int[][] copyArr = copyArr(arr);

		for(int i = startRow; i <= endRow; i++) {
			for(int j = startCol; j <= endCol; j++) {
				int cnt = 0;
				int sum = 0;

				for(int k = 0; k < 5; k++) {
					int nextRow = i + dx[k];
					int nextCol = j + dy[k];

					if(nextRow < 1 || nextRow > n || nextCol < 1 || nextCol > m) {
						continue;
					}

					sum += copyArr[nextRow][nextCol];
					cnt++;
				}

				arr[i][j] = sum / cnt;
			}
		}
	}

	public static int[][] copyArr(int[][] arr) {
		int[][] copyArr = new int[n + 1][m + 1];

		for(int i = 1; i <= n; i++) {
			if (m >= 0)
				System.arraycopy(arr[i], 1, copyArr[i], 1, m);
		}

		return copyArr;
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}