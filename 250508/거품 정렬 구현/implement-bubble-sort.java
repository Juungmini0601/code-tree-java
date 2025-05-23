import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		boolean sorted;

		do {
			sorted = true;
			for (int i = 0; i < n - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false;
				}
			}
		} while (sorted == false);

		for (int elem : arr) {
			System.out.print(elem + " ");
		}
	}
}