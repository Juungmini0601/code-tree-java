import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static int n, m;
	public static boolean[] visited;

	public static List<Edge>[] edges;
	public static final int INF = 99999999;

	public static Scanner sc = new Scanner(System.in);

	public static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		edges = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		// 인접 리스트 만들기
		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();

			Edge edge = new Edge(a, b, cost);
			edges[a].add(edge);
			edges[b].add(edge);
		}
	}

	public static void prim(int node) {
		int ans = 0;
		// node를 기준으로 Prim알고리즘을 돌린다.
		int[] distance = new int[n + 1];
		Arrays.fill(distance, INF);
		// 초기화
		distance[node] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(node, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.v]) {
				continue;
			}

			visited[cur.v] = true;
			ans += cur.cost;
			// System.out.println(cur);

			// 현재 노드의 정점에서 갈 수 있는 간선을 모두 비교하여 최소 값을 업데이트한다.
			for (Edge e : edges[cur.v]) {
				int nextDistance = e.cost;
				int nextV = e.a == cur.v ? e.b : e.a;

				if (nextDistance < distance[nextV]) {
					distance[nextV] = nextDistance;
					pq.add(new Node(nextV, nextDistance));
				}
			}
		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
		init();
		prim(1);
	}
}

class Edge {
	int a;
	int b;
	int cost;

	public Edge(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
}

class Node implements Comparable<Node> {
	int v;
	int cost;

	public Node(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}

	@Override
	public String toString() {
		return String.format("v: %d, cost:%d", v, cost);
	}
}