import java.util.Scanner;

// 일직선 위에 N개의 구간이 주어졌을 때 구간이 가장 많이 겹치는 부분에서 몇개의 구간이 겹치는가
public class Main {

	public static final int MAX = 200000;
	public static int n;

	public static int[] checked = new int[MAX + 1];

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			checked[start]++;
			checked[end]--;
		}
	}

	public static void solve() {
		int ans = Integer.MIN_VALUE;

		for (int i = 1; i <= MAX; i++) {
			int temp = 0;

			for (int j = 0; j < i; j++) {
				temp += checked[j];
			}

			ans = Math.max(ans, temp);
		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
		input();
		solve();
	}
}