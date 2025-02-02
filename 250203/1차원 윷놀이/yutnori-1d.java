import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이용 코드
 */
public class Main {

	public static int n, m, k;
	public static int[] selected;
	public static int[] moves;
	public static int maxScore = 0;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		select(0);

		System.out.println(maxScore);
	}

	public static void select(int cur) {
		if (cur == n) {
			maxScore = Math.max(maxScore, calcScore());
			return;
		}

		for (int i = 1; i <= k; i++) {
			selected[cur] = i;
			select(cur + 1);
		}
	}

	public static int calcScore() {
		int score = 0;
		int[] positions = new int[k + 1];
		Arrays.fill(positions, 1);

		for (int i = 0; i < n; i++) {
			int index = selected[i]; // 움직여야 할 말의 번호
			int move = moves[i]; // 움직여야 할 칸의 개수

			// 움직여야 할 말이 이미 끝에 있으면 넘어간다.
			if (positions[index] == m)
				continue;

			positions[index] += move;
			// 움직였는데 말이 끝에 도달하거나 넘어가면 점수를 추가하고 말을 끝 위치에 놓는다.
			if (positions[index] >= m) {
				score++;
				positions[index] = m;
			}
		}

		return score;
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 턴의 숫자
		m = Integer.parseInt(st.nextToken()); // 윷놀이 판의 크기 1 ~ m
		k = Integer.parseInt(st.nextToken()); // k 말의 개수 1 ~ k
		selected = new int[n];
		moves = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}
	}
}
