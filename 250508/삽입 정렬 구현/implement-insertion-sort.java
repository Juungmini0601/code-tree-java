import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// 삽입 정렬 구현
		for (int i = 1; i < n; i++) {
			int j = i - 1;
			int key = arr[i]; // 여기서 key를 왜 선언해줘야 하지?
			// 여기서 j + 1로 값을 옮기는 와중에 덮어 쓰여질 수 있기 때문이다.
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = key;
		}

		for (int elem : arr) {
			System.out.print(elem + " ");
		}
	}
}