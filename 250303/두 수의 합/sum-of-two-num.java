import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * N개의 정수가 입력으로 주어지고 서로 다른 위치에 있는 두 수를 뽑아 더했을 때 K가 되는 가지 수를 구하시오.
 * 아 이거 수가 중복으로 들어올 수 있네?
 *
 * 숫자가 중복으로 들어올 수 있으려면 어떻게 해야 하지?...
 * 리스트로 받거나 맵에서 카운트를 증가 시키거나
 * 그런데 리스트로 받으면 이중탐색해야 해서 아니거든? 그럼 일단 맵으로 카운트를 증가시킨다?
 */
public class Main {
	public static int n, k;
	public static long[] arr;
	public static Map<Long, Integer> map = new HashMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new long[n];

		for (int i = 0; i < n; i++) {
			long value = sc.nextLong();
			arr[i] = value;
		}

		int ans = 0;
		
		for(int i = 0 ; i < n; i++) {
			long diff = k - arr[i];
			
			if(map.containsKey(diff)) {
				ans += map.get(diff);
			}
			
			// 현재 숫자의 개수를 하나 증가시켜준다.
			map.put(arr[i], map.getOrDefault(arr[i], +1));
		}

		System.out.println(ans);
	}
}