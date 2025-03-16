import java.util.Scanner;

/**
 * ㅇㅣ중연결리스트
 *
 * Node data prev next
 *
 * 단일 노드 삽입 u: 연결리스트, s: 단일 노드
 * s.prev = u
 * s.next = u.next
 *
 * if(s.prev != null) s.prev.next = s
 * if(s.next != null) s.next.prev = s
 */
public class Main {

	static class Node {
		String data;
		Node prev;
		Node next;

		public Node(String data) {
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
			this.prev = newNode;
		}

		// 1 - 2 - 3
		// 1 - 2  - 0 - 3
		public void insertNext(Node newNode) {
			// 현재 노드의 다음에 삽입
			newNode.prev = this;
			newNode.next = this.next;

			this.next = newNode;
		}

		public Node prev() {
			return this.prev;
		}

		public Node next() {
			return this.next;
		}
	}

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Node cur = new Node(sc.next());
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int command = sc.nextInt();

			if (command == 1) {
				String word = sc.next();
				Node newNode = new Node(word);
				cur.insertPrev(newNode);
			} else if (command == 2) {
				String word = sc.next();
				Node newNode = new Node(word);
				cur.insertNext(newNode);
			} else if (command == 3) {
				if (cur.prev() != null) {
					cur = cur.prev();
				}
			} else if (command == 4) {
				if (cur.next() != null) {
					cur = cur.next();
				}
			}

			String data1 = cur.prev != null ? cur.prev.data : "(Null)";
			String data2 = cur != null ? cur.data : "(Null)";
			String data3 = cur.next != null ? cur.next.data : "(Null)";

			System.out.println(data1 + " " + data2 + " " + data3);
		}
	}
}