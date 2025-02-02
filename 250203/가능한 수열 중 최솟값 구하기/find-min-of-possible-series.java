import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 알고리즘 풀이용 코드
 */
public class Main {

	public static int n;
	public static int[] selected;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		select(1);
	}

	public static void select(int cur) {
		if (cur == n + 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= n; i++) {
				sb.append(selected[i]);
			}
			System.out.println(sb);
			System.exit(0);
		}

		for (int i = 4; i <= 6; i++) {
			if (cur == 1) {
				selected[cur] = i;
				select(cur + 1);
			} else {
				// 이미 뽑힌 숫자의 개수가 짝수인 경우
				int maxLength = ((cur - 1) % 2 == 0) ? (cur - 1) / 2 : cur / 2;
				if (canSelect(cur, maxLength, i)) {
					selected[cur] = i;
					select(cur + 1);
				}
			}
		}
	}

	// 1, 2 ... maxLength까지 2개의 인접한 연속 부분 수열이 같은 경우 가 없다.
	public static boolean canSelect(int cur, int maxLength, int nextNumber) {
		for (int curLength = 1; curLength <= maxLength; curLength++) {
			if (curLength == 1) {
				String temp1 = "" + nextNumber;
				String temp2 = "" + selected[cur - 1];

				if (temp1.equals(temp2)) {
					return false;
				}
			} else {
				int temp1StartIndex = cur - curLength + 1;
				// nextNumber를 포함하는 부분 수열
				String temp1 = makeString(temp1StartIndex, cur - 1) + nextNumber;
				// 연속한 길이가 같은 부분 수열
				String temp2 = makeString(temp1StartIndex - curLength, temp1StartIndex - 1);

				if (temp1.equals(temp2)) {
					return false;
				}
			}
		}

		return true;
	}

	public static String makeString(int startIndex, int endIndex) {
		StringBuilder sb = new StringBuilder();

		for (int i = startIndex; i <= endIndex; i++) {
			sb.append(selected[i]);
		}

		return sb.toString();
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		selected = new int[n + 1];
	}
}
