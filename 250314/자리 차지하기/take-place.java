import java.util.Scanner;
import java.util.TreeSet;

// M개의 비어있는 의자가 있다. 1 ~ M
// 사람들이 앉고자 하는 의자에 대한 정보 값이 N개 들어있다.
// ai는 1부터 ai 이하의 의자에만 앉고 싶다.
// 1번 사람부터 순서대로 해당 규칙에 맞춰 안기 시작하는데 앉지 못하는 사람이 있으면 종료하려고한다.
// 사람들이 앉을 자리를 적절하게 배정하여 앉게 되는 사람 수를 최대로 만드는 프로그램을 작성해라
// 걍 ai보다 작은 최대 값을 계속해서 꺼내주면 되네
public class Main {

	public static TreeSet<Integer> ts = new TreeSet<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;

		for (int i = 1; i <= m; i++) {
			ts.add(i);
		}

		for (int i = 1; i <= n; i++) {
			int v = sc.nextInt();
			Integer find = ts.floor(v);

			if (find == null) {
				break;
			}

			ts.remove(find);
			cnt++;
		}

		System.out.println(cnt);
	}
}