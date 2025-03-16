import java.util.Scanner;

/**
 * 1 ~ N까지 차례때로 번호가 붙어있는 N개의 단일 노드가 있다.
 * 1 i: i번 노드를 그 노드가 속해 있던 연결 리스트에서 뽑아서 단일 노드가 되게한다.
 * 2 i j: 단일 노드 j를 i번 노드 앞에 삽입
 * 3 i j: 단일 노드인 j를 i번 노드 뒤에 삽입
 * 4 i i번 노드의 이전 노드와 다음 노드의 번호를 출력
 */
public class Main {

	static class Node {
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}

		// 1 - 2 - 3
		// 1 - 0 - 2 - 3
		public void insertPrev(Node newNode) {
			// 현재 노드의 이전에 삽입
			newNode.prev = this.prev;
			newNode.next = this;

			// 현재 노드의 참조를 변경
			if (this.prev != null) {
				this.prev.next = newNode;
			}

			this.prev = newNode;
		}

		// 1 - 2 - 3
		// 1 - 2  - 0 - 3
		public void insertNext(Node newNode) {
			// 현재 노드의 다음에 삽입
			newNode.prev = this;
			newNode.next = this.next;

			if (this.next != null) {
				this.next.prev = newNode;
			}

			this.next = newNode;
		}

		// 현재 노드를 연결리스트에서 제거하고 혼자 남은 노드로 만들기
		public void remove() {
			// 1 - 2 - 3
			// 앞 뒤에 노드가 있는 경우
			if (this.prev != null && this.next != null) {
				this.prev.next = this.next;
				this.next.prev = this.prev;

				this.prev = null;
				this.next = null;
				return;
			}

			// 앞에만 노드가 있는 경우
			// 1 - 2
			if (this.prev != null) {
				this.prev.next = null;
				this.prev = null;
				return;
			}

			// 뒤에만 노드가 있는 경우
			// 2 - 3
			if (this.next != null) {
				this.next.prev = null;
				this.next = null;
				return;
			}
		}
	}

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int q = sc.nextInt();
		Node[] nodes = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
		}

		for (int x = 0; x < q; x++) {
			int command = sc.nextInt();

			if (command == 1) {
				int i = sc.nextInt();
				Node iNode = nodes[i];
				iNode.remove();
			} else if (command == 2) {
				int i = sc.nextInt();
				int j = sc.nextInt();

				Node jNode = nodes[j];
				Node iNode = nodes[i];
				iNode.insertPrev(jNode);
			} else if (command == 3) {
				int i = sc.nextInt();
				int j = sc.nextInt();

				Node jNode = nodes[j];
				Node iNode = nodes[i];
				iNode.insertNext(jNode);
			} else if (command == 4) {
				int i = sc.nextInt();
				Node iNode = nodes[i];

				int prev = iNode.prev != null ? iNode.prev.data : 0;
				int next = iNode.next != null ? iNode.next.data : 0;

				System.out.printf("%d %d\n", prev, next);
			}
		}

		for (int i = 1; i <= n; i++) {
			Node iNode = nodes[i];
			int next = iNode.next != null ? iNode.next.data : 0;
			System.out.print(next + " ");
		}
	}
}