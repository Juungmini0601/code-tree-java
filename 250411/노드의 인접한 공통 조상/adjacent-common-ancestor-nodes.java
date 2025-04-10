import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 루트가 있는 트리가 주어질때 두 노드의 가장 가까운 공통 조상을 찾아라.
// 노드의 번호 1 <= N <= 10000
// N-1개의 줄에서 a b 간선이 주어진다. 앞의 노드가 뒤의 노드의 부모 노드이다.
// N번째 줄에는 가장 가까운 공통 조상을 구할 두 노드가 주어진다.
public class Main {

	public static int n, a, b;
	public static int[] parents;
	public static List<Integer>[] childs;
	public static int[] depth;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		parents = new int[n + 1];
		childs = new ArrayList[n + 1];
		depth = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			childs[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n - 1; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();

			parents[child] = parent;
			childs[parent].add(child);
		}

		a = sc.nextInt();
		b = sc.nextInt();

		Arrays.fill(depth, 1);
	}

	public static int findRootNode() {
		int root = 0;
		for (int i = 1; i <= n; i++) {
			if (parents[i] == 0) {
				root = i;
				break;
			}
		}
		return root;
	}

	// DFS를 통해서 Depth 업데이트 칠거임
	public static void depth(int node) {
		// 탐색
		for (int child : childs[node]) {
			depth[child] = depth[node] + 1;
			depth(child);
		}
	}

	public static void lca() {
		// a와 b의 높이를 맞춰준다.
		while (depth[a] != depth[b]) {
			// 높이가 더 큰 친구가 부모 노드로 바꾸면서 올라간다.
			if (depth[a] > depth[b]) {
				a = parents[a];
			} else {
				b = parents[b];
			}
		}

		// a와 b가 같을때까지 부모로 올라간다.
		while (a != b) {
			a = parents[a];
			b = parents[b];
		}

		System.out.println(a);
	}

	public static void main(String[] args) {
		input();

		int root = findRootNode();
		depth(root);
		lca();
	}
}