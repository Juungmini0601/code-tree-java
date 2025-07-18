import java.util.Scanner;

public class Main {

	public static int[][][] block = {
		{
			{1, 0, 0},
			{1, 1, 0},
			{0, 0, 0}
		},
		{
			{0, 1, 0},
			{1, 1, 0},
			{0, 0, 0}
		},
		{
			{1, 1, 0},
			{1, 0, 0},
			{0, 0, 0}
		},
		{
			{1, 1, 0},
			{0, 1, 0},
			{0, 0, 0}
		},
		{
			{1, 1, 1},
			{0, 0, 0},
			{0, 0, 0}
		},
		{
			{1, 0, 0},
			{1, 0, 0},
			{1, 0, 0}
		}
	};

	public static int[][] grid;
	public static int n, m;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();
		int max = 0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				max = Math.max(max, select(i, j));
			}
		}

		System.out.println(max);
	}

	public static int select(int row, int col) {
		int maxScore = 0;

		for(int shape = 0; shape < 6; shape++) {
			boolean isPossible = true;
			int sum = 0;

			for(int dx = 0; dx < 3; dx++) {
				for(int dy = 0; dy < 3; dy++) {
					if (block[shape][dx][dy] == 0) continue;
					if (row + dx >= n || col + dy >= m) isPossible = false;
					else sum += grid[row + dx][col + dy];
				}
			}

			if (isPossible)
				maxScore = Math.max(maxScore, sum);
		}

		return maxScore;
	}


	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
	}
}