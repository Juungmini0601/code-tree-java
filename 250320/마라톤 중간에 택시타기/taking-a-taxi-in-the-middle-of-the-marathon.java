import java.util.Scanner;

public class Main {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int distance(Pos p) {
			return Math.abs(x - p.x) + Math.abs(y - p.y);
		}
	}

	public static int n;
	public static Pos[] positions = new Pos[n];
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
		int[] L = new int[n + 1]; // L[i] = 시작 지점부터 i까지 가는데 걸리는 거리
		int[] R = new int[n + 1]; // R[i] = i부터 끝지점까지 가는데 걸리는 거리

		L[1] = 0;
		for (int i = 2; i <= n; i++) {
			L[i] = positions[i].distance(positions[i - 1]) + L[i-1];
		}

		R[n] = 0;
		for(int i = n-1; i > 0; i--) {
			R[i] = positions[i].distance(positions[i + 1]) + R[i+1];
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 2; i < n; i++) {
			int distance = L[i-1] + R[i + 1] + positions[i-1].distance(positions[i+1]);
			ans = Math.min(ans, distance);
		}

		System.out.println(ans);
	}

	public static void init() {
		n = sc.nextInt();
		positions = new Pos[n + 1];

		for (int i = 1; i <= n; i++) {
			positions[i] = new Pos(sc.nextInt(), sc.nextInt());
		}
	}
}