import java.util.Scanner;

public class Main {

	public static int n;
	public static int[][] arr;

	public static final int COIN = 1;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int ans = 0;
		input();

		for(int i = 0; i <= n - 3; i++) {
			for(int j = 0; j <= n-3; j++) {
				ans = Math.max(ans, count(i, j));
			}
		}

		System.out.println(ans);
	}

	public static void input() {
		n = sc.nextInt();
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}

	public static int count(int row, int col) {
		int count = 0;

		for(int i = row; i < row + 3; i++) {
			for(int j = col; j < col + 3; j++) {
				if (arr[i][j] == COIN) {
					count++;
				}
			}
		}

		return count;
	}
}