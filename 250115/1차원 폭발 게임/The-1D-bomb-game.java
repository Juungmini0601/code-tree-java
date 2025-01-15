import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int n;
	public static int m;
	public static int[] bombs;
	public static final int MARK = -1;
	public static final int BLANK= 0;

	public static void main(String[] args) throws Exception {
		input();

		while(true) {
			// m개 이상 연속적인 숫자가 있는지 판단한다.
			boolean check = condition();
			if(!check) break;

			// MARK된 친구들을 제외하고 폭탄을 이동시킨다.
			int[] temp = new int[n];
			int tempIndex = 0;
			for(int i = 0; i < n; i++) {
				if (bombs[i] == MARK || bombs[i] == BLANK) continue;
				temp[tempIndex++] = bombs[i];
			}

			bombs = temp;
		}

		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(bombs[i] == BLANK) break;
			cnt++;
		}

		System.out.println(cnt);
		for(int i = 0; i < n; i++) {
			if(bombs[i] == BLANK) break;
			System.out.println(bombs[i]);
		}
	}

	public static boolean condition() {
		int cnt = 1;
		boolean ret = false;
		int startIndex = 0;
		int endIndex = n;
		for(int i = 1; i < n; i++) {
			if(bombs[i] == BLANK) {
				endIndex = i;
				break;
			}

			if (bombs[i] == bombs[i - 1]) {
				cnt++;
				continue;
			}
			// 폭탄 번호가 바뀌는 경우
			if(cnt >= m) {
				ret = true;
				mark(bombs[i-1], startIndex, i);
			}

			cnt = 1;
			startIndex = i;
		}

		if(cnt >= m) {
			ret = true;
			mark(bombs[endIndex-1], startIndex, endIndex);
		}

		return ret;
	}

	public static void mark(int num, int startIndex, int endIndex) {
		for(int i = startIndex; i < endIndex; i++) {
			if (bombs[i] == num) {
				bombs[i] = MARK;
			}
		}
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		bombs = new int[n];

		for(int i = 0; i < n; i++) {
			bombs[i] = Integer.parseInt(br.readLine());
		}
	}
}

