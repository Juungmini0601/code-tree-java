import java.util.Scanner;
import java.util.TreeSet;

// 1 ~ M까지 적혀있는 공이 있다.
// N개의 숫자들이 주어질 때 순서대로 해당 숫자가 적혀있는 공을 제거 한 후 남아 있는 공의 최대 번호를 출력해라.
public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 1; i <= m; i++) {
			ts.add(i);
		}

		for (int i = 0; i < n; i++) {
			int v = sc.nextInt();
			ts.remove(v);

			System.out.println(ts.last());
		}
	}
}