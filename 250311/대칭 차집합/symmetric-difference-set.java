import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static int na, nb;
	public static Set<Integer> a, b, ab, ba;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		na = sc.nextInt();
		nb = sc.nextInt();
		
		a = new HashSet<>();
		b = new HashSet<>();
		ab = new HashSet<>();
		ba = new HashSet<>();

		for (int i = 0; i < na; i++) {
			int val = sc.nextInt();
			a.add(val);
			ab.add(val);
		}

		for (int i = 0; i < nb; i++) {
			int val = sc.nextInt();
			b.add(val);
			ba.add(val);
		}

		ab.removeAll(b);
		ba.removeAll(a);

		System.out.println(ab.size() + ba.size());
	}
}