import java.util.Scanner;

public class Main {

	public static int n, m;
	public static int[] parent;

	public static Scanner sc = new Scanner(System.in);

	public static void init() {
		n = sc.nextInt();
		m = sc.nextInt();

		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		parent[aRoot] = bRoot;
	}

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		int root = find(parent[x]);
		parent[x] = root;
		return root;
	}

	public static void main(String[] args) {
		init();

		for (int i = 0; i < m; i++) {
			int command = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (command == 0) {
				union(a, b);
			} else if (command == 1) {
				System.out.println(find(a) == find(b) ? 1 : 0);
			}
		}
	}
}