import java.util.Scanner;

public class Main {

	public static final int MAX_N = 100;

	public static int n;
	public static int[] arr = new int[MAX_N + 1];

	public static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
	}

	public static void remove(int startIndex, int endIndex) {
		int[] temp = new int[MAX_N + 1];
		int tempIndex = 0;

		for (int i = startIndex; i <= endIndex; i++) {
			arr[i] = 0;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				temp[tempIndex++] = arr[i];
			}
		}

		arr = temp;
	}

	public static void main(String[] args) {
		input();

		for (int i = 0; i < 2; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			remove(s - 1, e - 1);
		}

		int cnt = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				break;
			}

			cnt++;
			sb.append(arr[i])
				.append("\n");
		}

		System.out.println(cnt);
		System.out.println(sb);
	}
}