import java.util.Scanner;

public class Main {

	public static int ans = 0;
	public static int n;
	public static int[][] grid;

	public static Scanner sc = new Scanner(System.in);

	public static int countCoinsOfGrid(int startRow, int startCol, int endRow, int endCol) {
		int cnt = 0;

		for(int r = startRow; r <= endRow; r++) {
			for(int c = startCol; c <= endCol; c++) {
				if(grid[r][c] == 1) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		// Input
		n = sc.nextInt();
		grid = new int[n][n];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				if (row + 2 < n && col + 2 < n) {
					ans = Math.max(ans, countCoinsOfGrid(row, col, row + 2, col + 2));
				}
			}
		}

		System.out.println(ans);
	}
}