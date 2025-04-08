import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
	char data;
	Node left;
	Node right;

	Node(char data) {
		this.data = data;
	}
}

public class Main {

	public static int n;
	public static Map<Character, Node> tree = new HashMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();

		for (int i = 1; i <= 26; i++) {
			char c = (char)('A' + i - 1);
			tree.put(c, new Node(c));
		}

		for (int i = 1; i <= n; i++) {
			char parentData = sc.next().charAt(0);
			char leftChildData = sc.next().charAt(0);
			char rightChildData = sc.next().charAt(0);

			Node parent = tree.get(parentData);

			if (leftChildData != '.') {
				Node leftChild = tree.get(leftChildData);
				parent.left = leftChild;
			}

			if (rightChildData != '.') {
				Node rightChild = tree.get(rightChildData);
				parent.right = rightChild;
			}
		}
	}

	public static void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + "");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + "");
	}

	public static void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + "");
		inOrder(node.right);
	}

	public static void main(String[] args) {
		input();
		preOrder(tree.get('A'));
		System.out.println();
		inOrder(tree.get('A'));
		System.out.println();
		postOrder(tree.get('A'));
	}
}