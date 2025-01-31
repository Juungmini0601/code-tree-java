import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int k, n;
	public static int[] selected;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		select(0);
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(selected[i] + " ");
		}
	}

	public static void select(int cur) {
		if (cur == n) {
			print();
			System.out.println();
			return;
		}

		for (int i = 1; i <= k; i++) {
			if (cur < 2 || check(cur, i)) {
				selected[cur] = i;
				select(cur + 1);
			}
		}
	}

	// curIndex -1, curIndex-2 val이 모두 같으면 안됨
	public static boolean check(int curIndex, int val) {
		return !(selected[curIndex - 1] == val && selected[curIndex - 2] == val);
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		selected = new int[n];
	}
}