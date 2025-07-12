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

		for(int i = 0; i < n - 1; i++) {
			int min = i;
			for(int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}

		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}