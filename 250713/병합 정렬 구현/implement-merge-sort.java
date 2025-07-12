import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int[] arr;

	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int[n];

		for(int i = 0; i < n; i++ ) {
			arr[i] = sc.nextInt();
		}

		mergeSort(0, n-1);
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void mergeSort(int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	public static void merge(int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = low;
		int[] merged_arr = new int[n];

		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				merged_arr[k] = arr[i];
				i++;
				k++;
			} else {
				merged_arr[k] = arr[j];
				j++;
				k++;
			}
		}

		while (i <= mid) {
			merged_arr[k] = arr[i];
			i++;
			k++;
		}

		while (j <= high) {
			merged_arr[k] = arr[j];
			j++;
			k++;
		}

		for(int x = low; x <= high; x++) {
			arr[x] = merged_arr[x];
		}
	}
}