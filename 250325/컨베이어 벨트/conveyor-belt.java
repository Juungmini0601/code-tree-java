import java.util.Scanner;

public class Main {

	public static int MAX_N = 200;
	public static int[][] grid = new int[2][MAX_N + 1];

	public static int n, t;
	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		t = sc.nextInt();

		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
	}

	public static void shift() {
		int temp = grid[0][n-1];

		for(int col = n-1; col > 0; col--) {
			grid[0][col] = grid[0][col-1];
		}

		grid[0][0] = grid[1][n-1];

		for(int col = n-1; col > 0; col--) {
			grid[1][col] = grid[1][col-1];
		}

		grid[1][0] = temp;
	}

	public static void print() {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		input();

		for(int i = 0; i < t; i++) {
			shift();
		}

		print();
	}
}