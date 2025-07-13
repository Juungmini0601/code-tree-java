import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int[] arr;

	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		quickSort(0, n-1);

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
		int pivot = high;
		int left = low - 1;

		for (int right = low; right <= high; right++) {
			if (arr[right] < arr[pivot]) {
				left++;
				swap(left, right);
			}
		}

		swap(left + 1, pivot);
		return left + 1;
	}

	public static void swap(int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}