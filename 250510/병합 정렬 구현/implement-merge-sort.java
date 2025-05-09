import java.util.Scanner;

public class Main {

	public static int[] newArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		newArr = new int[arr.length];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		merge_sort(arr, 0, arr.length - 1);
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
	}

	public static void merge_sort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			merge_sort(arr, low, mid);
			merge_sort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int left = low;
		int right = mid + 1;
		int cur = low;

		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				newArr[cur] = arr[left];
				cur++;
				left++;
			} else {
				newArr[cur] = arr[right];
				cur++;
				right++;
			}
		}

		while (left <= mid) {
			newArr[cur] = arr[left];
			cur++;
			left++;
		}

		while (right <= high) {
			newArr[cur] = arr[right];
			cur++;
			right++;
		}

		for (int i = low; i <= high; i++) {
			arr[i] = newArr[i];
		}
	}
}