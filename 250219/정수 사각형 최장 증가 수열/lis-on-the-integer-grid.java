import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * n * n 크기의 격자 정보가 주어진다.
 * 시작점을 적절하게 잡아 상하좌우로 칸에 적혀있는 정수 값이 커지도록 이동한다.
 * 밟고 지나 갈 수 있는 최대 칸의 수를 구하시오.
 */
public class Main {

	public static int n;
	public static int[][] arr;
	// dp[i][j]는 (i, j)를 시작점으로 했을 때 움직일 수 있는 최대 거리
	public static int[][] dp;
	public static List<int[]> points = new ArrayList<>();
	// 상 우 하 좌
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();
		int ans = 0;
		// 내림차순으로 정렬
		points.sort(Comparator.comparingInt((int[] e) -> e[2]).reversed());

		for (int[] point : points) {
			int x = point[0];
			int y = point[1];
			dp[x][y] = 1;
			int curValue = point[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 1 || nx > n || ny < 1 || ny > n) {
					continue;
				}

				if (arr[nx][ny] <= curValue) {
					continue;
				}

				dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
			}

			ans = Math.max(ans, dp[x][y]);
		}
		
		System.out.println(ans);
	}

	public static void input() {
		n = sc.nextInt();
		arr = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
				points.add(new int[] {i, j, arr[i][j]});
			}
		}
	}
}