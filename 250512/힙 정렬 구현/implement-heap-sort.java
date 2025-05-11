import java.util.Scanner;

public class Main {

	public static int n;
	public static int[] arr;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		heap_sort();

		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void heap_sort() {
		for (int i = n / 2; i >= 1; i--) {
			heapify(n, i);
		}

		for (int i = n; i > 1; i--) {
			swap(1, i);
			heapify(i - 1, 1);
		}
	}

	public static void heapify(int n, int i) {
		int largest = i;
		int left = i * 2;
		int right = i * 2 + 1;

		if (left <= n && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right <= n && arr[right] > arr[largest]) {
			largest = right;
		}

		if (i != largest) {
			swap(i, largest);
			heapify(n, largest);
		}
	}

	public static void swap(int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}