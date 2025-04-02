import java.util.Scanner;

// N개의 체크포인트로 구성되어 있는 마라톤 코스
// 1번부터 모든 체크 포인트를 방문 N번 포인트에서 종료
// 중간에 있는 체크포인트 하나를 건너 뛰려함, 1번과 마지막은 무조건 포함
// 거리 계산은 멘하탄 거리
// 체크 포인트의 좌표는 겹쳐 주어질 수 있긴함.
public class Main {

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int distance(Pos p) {
			return Math.abs(x - p.x) + Math.abs(y - p.y);
		}
	}

	public static Pos[] points;
	public static int[] L, R;

	public static int n;

	public static Scanner sc = new Scanner(System.in);

	public static void init() {
		n = sc.nextInt();
		points = new Pos[n];
		L = new int[n];
		R = new int[n];

		for (int i = 0; i < n; i++) {
			points[i] = new Pos(sc.nextInt(), sc.nextInt());
		}

		// L 배열에 값 채워 넣기
		L[0] = 0;
		for (int i = 1; i < n; i++) {
			L[i] = L[i - 1] + points[i - 1].distance(points[i]);
		}

		// R 배열에 값 채워 넣기
		L[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			R[i] = R[i + 1] + points[i + 1].distance(points[i]);
		}
	}

	public static void solve() {
		int ans = Integer.MAX_VALUE;

		for (int i = 1; i < n - 1; i++) {
			int temp = L[i - 1] + R[i + 1] + points[i - 1].distance(points[i + 1]);
			ans = Math.min(ans, temp);
		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
		init();
		solve();
	}
}