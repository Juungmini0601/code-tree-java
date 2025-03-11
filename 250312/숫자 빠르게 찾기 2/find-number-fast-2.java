import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static int n, m;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			ts.add(sc.nextInt());
		}

		for (int i = 0; i < m; i++) {
			Integer val = ts.ceiling(sc.nextInt());
			if (val == null) {
				System.out.println(-1);
			} else {
				System.out.println(val);
			}
		}
	}
}