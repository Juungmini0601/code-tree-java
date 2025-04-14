import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author    : kimjungmin
 * Created on : 2025. 4. 15.
 */
public class Main {

	public static int n;
	public static int ans;

	public static List<Integer> permutations = new ArrayList<>();

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
	}

	// permutations에 있는 값이 아름 다운 수 인지 확인
	public static boolean check() {
		int cnt = 1;
		int num = permutations.get(0);

		for (int i = 1; i < permutations.size(); i++) {
			int cur = permutations.get(i);

			if (cur == num) {
				cnt++;
				continue;
			}

			// 이전 값과 현재 값이 다를 경우 그 전 숫자가 아름 다운 수의 조건에 맞았는지 확인
			if (cnt % num == 0) {
				cnt = 1;
				num = cur;
			} else {
				return false;
			}
		}

		// 마지막 숫자에 대한 판단.
		if (cnt % num == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void select(int cur) {
		if (cur >= n) {
			// 여기서 아름다운 수인지 확인
			if (check()) {
				ans++;
			}
			return;
		}

		for (int i = 1; i <= 4; i++) {
			permutations.add(i);
			select(cur + 1);
			permutations.remove(cur);
		}
	}

	public static void solve() {
		select(0);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		input();
		solve();
	}
}
