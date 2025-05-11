import java.util.Scanner;

public class Main {

	public static int n;
	public static int[] arr;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		quickSort(0, n - 1);

		for (int elem : arr) {
			System.out.print(elem + " ");
		}
	}

	public static void quickSort(int low, int high) {
		if (low < high) {
			int p = partition(low, high);
			quickSort(low, p - 1);
			quickSort(p + 1, high);
		}
	}

	public static int partition(int low, int high) {
		int pivot = arr[high];

		int lower = low - 1; // pivot보다 크거나 같은 값을 가르킬 커서
		for (int greater = low; greater <= high - 1; greater++) {
			if (arr[greater] < pivot) {
				lower++;
				swap(lower, greater);
			}
		}

		swap(lower + 1, high);
		return lower + 1;
	}

	public static void swap(int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}