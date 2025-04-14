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
		// 시작점의 위치를 잡는다.
		for (int i = 0; i < permutations.size(); i += permutations.get(i)) {
			// 현재 위치에서 현재 값 만큼 연속이라고 했을때 사이즈를 넘어가면 아름다운 수가 아니다.
			if (i + permutations.get(i) - 1 >= n) {
				return false;
			}
			
			for(int j = i; j < i + permutations.get(i); j++) {
				if (permutations.get(i) != permutations.get(j)) {
					return false;
				}
			}
		}
		
		return true;
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
