import java.util.Scanner;
import java.util.TreeSet;

// N개의 정수로 이루어진 수열에서 두개의 수를 골랐다.
// diff가 M이상이면서 제일 작은 경우를 고르시오.

// [1, 2, 3, 4, 5, 6, 7, 8, 9] -> 차이의 최대 값 = 8
// 차이 값을 줄이는 방법은 2가지가 있다. 1. 최소값의 크기를 키운다, 2. 최대값의 크기를 줄인다.
// 최소값을 미리 골라둔다. 1
// 최소값보다 크거나 같은 숫자들 중 제일 작은거를 계속 뽑아보면서 비교한다.
public class Main {

	public static TreeSet<Integer> ts = new TreeSet<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();

		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			ts.add(sc.nextInt());
		}

		int ans = Integer.MAX_VALUE;  
		for (Integer first : ts) {
			Integer next = ts.ceiling(first + m);  
			if (next != null) {
				ans = Math.min(ans, next - first); 
			}
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);  
		} else {
			System.out.println(ans); 
		}
	}

}