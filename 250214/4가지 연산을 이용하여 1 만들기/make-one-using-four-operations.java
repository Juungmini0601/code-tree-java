import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 정수 N이 주어질때 4가지 연산을 해서 연산의 회수를 최소화 하여 1을 만드려고함.
 *
 * 1. 현재수에서 1을 뺌
 * 2. 현재수에서 1을 더함 
 * 3. 현재 수가 2로 나누어떨어질 경우 현재 수를 2로 나눔
 * 4. 현재 수가 3으로 나누어 떨어질 경우 현재 수를 3으로 나눔
 *
 * 1을 만들기 위한 최소 연산 회수를 구해보시오~
 */
public class Main {

	public static int n;
	// 아무리 생각해도 200만 이상 갈 수 가 없음 정확히는 100만 1이기는한데
	public static int[] distance = new int[2_000_001];
	public static int MAX = 2_000_000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		Queue<Integer> q = new ArrayDeque<>();
		distance[n] = 1;
		q.offer(n);

		while (!q.isEmpty()) {
			int current = q.poll();

			if (current == 1) {
				System.out.println(distance[current] - 1);
				return;
			}

			// 1을 더하는 경우
			if (current + 1 <= MAX && distance[current + 1] == 0) {
				distance[current + 1] = distance[current] + 1;
				q.offer(current + 1);
			}
			// 1을 빼는 경우
			if (current - 1 >= 2 && distance[current - 1] == 0) {
				distance[current - 1] = distance[current] + 1;
				q.offer(current - 1);
			}
			// 2를 나눌수 있는 경우
			if (current % 2 == 0 && distance[current / 2] == 0) {
				distance[current / 2] = distance[current] + 1;
				q.offer(current / 2);
			}
			// 3으로 나눌 수 있는 경우
			if (current % 3 == 0 && distance[current / 3] == 0) {
				distance[current / 3] = distance[current] + 1;
				q.offer(current / 3);
			}
		}
	}

}
