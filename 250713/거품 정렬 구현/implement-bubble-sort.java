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

		boolean isSorted = false;

		do {
			isSorted = true;
			for(int i = 0; i < n-1; i++) {
				if (arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					isSorted = false;
				}
			}
		} while (!isSorted);

		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}