import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int[] arr;

	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 삽입 정렬
		for(int i = 1; i < n; i++) {
			int j = i - 1;
			int key = arr[i];

			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}

			arr[j+1] = key;
		}

		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}