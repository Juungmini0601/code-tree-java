import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int n;
	public static int k;
	public static int[] arr;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		input();
		select(0);
	}

	public static void select(int cur) {
		if (cur == n) {
			for(int i = 0; i < n; i++) {
				 System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i = 1; i <= k; i++) {
			arr[cur] = i;
			select(cur + 1);
		}
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n];
	}
}