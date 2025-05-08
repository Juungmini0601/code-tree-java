import java.util.LinkedList;
import java.util.Scanner;

// 6
// 1 10 100 1000 10000 100000
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];

		int maxPos = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
			maxPos = Math.max(maxPos, arr[i].length());
		}

		// 배열의 모든 숫자의 자리수를 맞춰준다.
		for (int i = 0; i < n; i++) {
			arr[i] = changeNumber(arr[i], maxPos);
		}

		// 각 자리수 별로 기수 정렬을 진행할 것이다.
		for (int pos = maxPos - 1; pos >= 0; pos--) {
			LinkedList<String>[] lists = new LinkedList[10];
			for (int i = 0; i < 10; i++) {
				lists[i] = new LinkedList<>();
			}
			// 배열을 모두 순회하면서 각 자리수에 해당하는 배열에 숫자를 넣는다.
			for (String number : arr) {
				int digit = number.charAt(pos) - '0';
				lists[digit].addLast(number);
			}

			String[] newArr = new String[n];
			int cur = 0;

			for (int i = 0; i < 10; i++) {
				LinkedList<String> list = lists[i];

				for (String elem : list) {
					newArr[cur++] = elem;
				}
			}

			arr = newArr;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(Integer.parseInt(arr[i]) + " ");
		}
	}

	private static String changeNumber(String value, int maxPos) {
		StringBuilder ret = new StringBuilder(value);
		while (ret.length() < maxPos) {
			ret.insert(0, "0");
		}

		return ret.toString();
	}
}