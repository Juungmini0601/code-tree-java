import java.util.Scanner;
import java.util.TreeSet;

/**
 * 이 문제에서 눈 여겨 볼 점은 뒤에서 따라잡은 점의 속도가 무조건 빠를 수 밖에 없다는 것이다.
 * 따라서 이미 있으면 걍 스킵하는게 맞음 그니까 equals는 p만 비교하면됨.
 */
public class Main {

	public static int n, t;
	public static TreeSet<Node> set = new TreeSet<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();
		// t분의 달리기를 한다.
		for (int i = 0; i < t; i++) {
			run();
		}

		System.out.println(set.size());
	}

	public static void run() {
		TreeSet<Node> nextSet = new TreeSet<>();

		for (Node n : set) {
			Node nextNode = new Node(n.p + n.v, n.v);

			// if (nextSet.contains(nextNode)) {
			// 	System.out.println("하나 겹쳤다!" + nextSet);
			// }

			nextSet.add(nextNode);
		}

		set = nextSet;
		// System.out.println(set);
	}

	public static void input() {
		n = sc.nextInt();
		t = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int p = sc.nextInt();
			int t = sc.nextInt();

			Node node = new Node(p, t);
			set.add(node);
		}
	}
}

class Node implements Comparable<Node> {
	long p;
	long v;

	public Node(long p, long v) {
		this.p = p;
		this.v = v;
	}

	@Override
	public int compareTo(Node o) {
		return -Long.compare(this.p, o.p); // p 값만 비교
	}

	@Override
	public String toString() {
		return "Node{" +
			"p=" + p +
			", v=" + v +
			'}';
	}
}