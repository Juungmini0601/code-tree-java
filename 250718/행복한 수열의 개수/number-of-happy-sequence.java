import java.util.Scanner;

public class Main {

	public static int n, m;
	public static int[][] grid;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();

		int ans = 0;

		for(int i = 0; i < n; i++) {
			ans += rowCheck(i);
			ans += colCheck(i);
		}

		System.out.println(ans);
	}

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][n];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
	}

	public static int rowCheck(int row) {
		int max = 0;
		int cnt = 0;

		for(int col = 1; col < n; col++) {
			if (grid[row][col-1] == grid[row][col]) {
				cnt++;
				max = Math.max(cnt, max);
			} else {
				cnt = 1;
				max = Math.max(cnt, max);
			}
		}

		return max >= m ? 1 : 0;
	}

	public static int colCheck(int col) {
		int max = 0;
		int cnt = 0;

		for(int row = 1; row < n; row++) {
			if (grid[row-1][col] == grid[row][col]) {
				cnt++;
				max = Math.max(cnt, max);
			} else {
				cnt = 1;
				max = Math.max(cnt, max);
			}
		}

		return max >= m ? 1 : 0;
	}
}