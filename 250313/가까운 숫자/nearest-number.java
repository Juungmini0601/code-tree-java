import java.util.Scanner;
import java.util.TreeSet;

// 1 ~ M까지 적혀있는 공이 있다.
// N개의 숫자들이 주어질 때 순서대로 해당 숫자가 적혀있는 공을 제거 한 후 남아 있는 공의 최대 번호를 출력해라.
public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(0);

		for (int i = 0; i < n; i++) {
			int v = sc.nextInt();
			ts.add(v);

			Integer higher = ts.higher(v);
			Integer lower = ts.lower(v);

			if (higher != null) {
				ans = Math.min(higher - v, ans);
			}

			if (lower != null) {
				ans = Math.min(v - lower, ans);
			}

			System.out.println(ans);
		}
	}
}