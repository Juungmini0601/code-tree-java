import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static int n, m;
	public static String[] a;
	public static String[] b;

	public static Set<String> setA = new HashSet<>();
	public static Set<String> setB = new HashSet<>();

	public static int cnt = 0;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();

		a = new String[n];
		b = new String[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLine();
		}

		for (int i = 0; i < n; i++) {
			b[i] = sc.nextLine();
		}

		for (int i = 0; i < m - 2; i++) {
			for (int j = i + 1; j < m - 1; j++) {
				for (int k = j + 1; k < m; k++) {
					// i, j, k에 대해서 2개의 그룹이 분할 쳐지는게 맞으면
					// System.out.println(i + " " + j + " " + k);
					solve(i, j, k);
				}
			}
		}

		System.out.println(cnt);
	}

	// i, j, k일떄
	public static void solve(int i, int j, int k) {
		// 집합 A의 모든 부분 문자열을 구한다.
		for (int index = 0; index < n; index++) {
			String str = a[index];
			// System.out.println(str);
			setA.add("" + str.charAt(i) + str.charAt(j) + str.charAt(k));
		}

		// 집합 B의 모든 부분 문자열을 구한다.
		for (int index = 0; index < n; index++) {
			String str = b[index];
			setB.add("" + str.charAt(i) + str.charAt(j) + str.charAt(k));
		}

		// 집합 B의 모든 부분 문자열이 A에 포함되지 않는다면 카운트를 늘린다.
		boolean isAnswer = true;
		for (String key : setB) {
			if (setA.contains(key)) {
				isAnswer = false;
				break;
			}
		}

		if (isAnswer) {
			cnt++;
		}

		setA.clear();
		setB.clear();
	}
}