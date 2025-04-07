import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

// N개의 정점이 존재한다. M개의 간선의 양 끝 정점과 가중치가 주어진다.
// 1번 정점에서 다른 모든 정점으로 가는 최단 거리를 구하는 알고리즘을 작성하라.
// 그래프는 단방향 그래프이다.
// N <= 100, M <=1000 가중치 <=10
// 동일한 간선이 주어지는 경우는 없다.
public class Main {

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
	}

	public static int n, m;
	public static Map<Integer, List<Edge>> graph = new HashMap<>();
	public static int[] dist;

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			Edge edge = new Edge(start, end, weight);

			if (!graph.containsKey(start)) {
				graph.put(start, new ArrayList<>());
			}

			graph.get(start).add(edge);
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		dist[start] = 0;

		for (int i = 1; i <= n; i++) {
			pq.offer(new int[] {i, dist[i]});
		}

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int v = cur[0];
			List<Edge> edges = graph.get(v);

			if (edges == null) {
				continue;
			}
			
			for (Edge edge : edges) {
				int next = edge.end;
				int nextDist = dist[v] + edge.weight;

				if (nextDist < dist[next]) {
					dist[next] = nextDist;
					pq.offer(new int[] {next, nextDist});
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		dijkstra(1);

		for (int i = 2; i <= n; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
		}
	}
}