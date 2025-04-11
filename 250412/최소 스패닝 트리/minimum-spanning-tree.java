import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1~N까지의 정점과 M개의 간선에 대한 정보가 주어진다.
 * 주어진 그래프에서 최소 스패닝 트리를 구하시오
 */
public class Main {
	public static int n, m;
	public static int[] parents;
	public static PriorityQueue<Edge> edges = new PriorityQueue<>();

	public static Scanner sc = new Scanner(System.in);

	public static void init() {
		n = sc.nextInt();
		m = sc.nextInt();

		parents = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int cost = sc.nextInt();

			edges.offer(new Edge(v1, v2, cost));
		}

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	// a노드를 b노드로 연결함
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		parents[a] = b;
	}

	// x노드의 부모를 찾음
	public static int find(int x) {
		if (parents[x] == x) {
			return x;
		}

		int rootNode = find(parents[x]);
		parents[x] = rootNode;
		return rootNode;
	}

	public static void kruskal() {
		int sum = 0;
		int cnt = 0; // 선택된 간선의 개수 N-1이 되면 된거임

		while (cnt < n - 1) {
			// 현재 간선중 가장 비용이 작은 친구
			Edge e = edges.poll();
			if (e == null) {
				System.out.println("유효한 간선이 남아있지 않습니다.");
				return;
			}
			// 두 간선을 이었을 때 사이클이 발생 하는지?
			int v1 = e.v1;
			int v2 = e.v2;

			if (find(v1) != find(v2)) {
				// 현재 간선을 선택함
				// System.out.println("선택된 간선: " + e);
				union(v1, v2);
				cnt++;
				sum += e.cost;
			}
		}

		System.out.println(sum);
	}

	public static void main(String[] args) {
		init();
		kruskal();
	}
}

class Edge implements Comparable<Edge> {
	int v1;
	int v2;
	int cost;

	public Edge(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.cost, o.cost);
	}

	@Override
	public String toString() {
		return String.format("[%d, %d] cost: %d", v1, v2, cost);
	}
}