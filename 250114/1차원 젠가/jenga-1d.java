import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int n;
	public static int[] blocks;
	public static final int EMPTY = 0;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		blocks = new int[n + 1];

		for(int i = 1; i <= n; i++) {
			blocks[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 1; i <= 2; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for(int j = start; j <= end; j++) {
				blocks[j] = EMPTY;
			}

			int[] temp = new int[n + 1];
			int tempIndex = 1;

			for(int j = 1; j <= n; j++) {
				if(blocks[j] != EMPTY) {
					temp[tempIndex++] = blocks[j];
				}
			}

			blocks = temp;
		}

		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(blocks[i] != EMPTY) {
				cnt++;
			}
		}

		System.out.println(cnt);
		for(int i = 1; i <= cnt; i++) {
			System.out.println(blocks[i]);
		}
	}
}

