import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static int n;

	public static Map<Long, Integer> map = new HashMap<>();

	public static int[] a;
	public static int[] b;
	public static int[] c;
	public static int[] d;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		a = new int[n];
		b = new int[n];
		c = new int[n];
		d = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		for (int i = 0; i < n; i++)
			b[i] = sc.nextInt();

		for (int i = 0; i < n; i++)
			c[i] = sc.nextInt();

		for (int i = 0; i < n; i++)
			d[i] = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				long key = a[i] + b[j];
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				long key = c[i] + d[j];
				if (map.getOrDefault(-key, 0) > 0) {
					ans += map.get(-key);
				}
			}
		}

		System.out.println(ans);
	}
}