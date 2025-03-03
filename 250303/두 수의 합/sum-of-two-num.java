import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * N개의 정수가 입력으로 주어지고 서로 다른 위치에 있는 두 수를 뽑아 더했을 때 K가 되는 가지 수를 구하시오.
 */
public class Main {
	public static int n, k;
	public static Set<Integer> set = new HashSet<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			set.add(value);
		}

		int cnt = 0;

		for (Integer value : set) {
			if (set.contains(Math.abs(k - value))) {
				cnt++;
			}
		}

		System.out.println(cnt / 2);
	}
}