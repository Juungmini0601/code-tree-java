import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;
	public static int r;
	public static int c;
	public static int m1;
	public static int m2;
	public static int m3;
	public static int m4;
	public static int dir;


	public static void main(String[] args) throws Exception {
		input();

		// 1번 방향으로 존재하는 모든 좌표를 배열 형태로 만든다.
		Pos[] positions1 = new Pos[m1+1];
		int curRow = r;
		int curCol = c;
		positions1[0] = new Pos(curRow, curCol);

		for (int i = 1; i <= m1; i++) {
			curRow--;
			curCol++;
			positions1[i] = new Pos(curRow, curCol);
		}
		// 2번 방향으로 존재하는 모든 좌표를 배열 형태로 만든다.
		Pos[] positions2 = new Pos[m2+1];
		positions2[0] = new Pos(curRow, curCol);
		for(int i = 1; i <= m2; i++) {
			curRow--;
			curCol--;
			positions2[i] = new Pos(curRow, curCol);
		}
		// 3번 방향으로 존재하는 모든 좌표를 배열 형태로 만든다.
		Pos[] positions3 = new Pos[m3+1];
		positions3[0] = new Pos(curRow, curCol);
		for(int i = 1; i <= m3; i++) {
			curRow++;
			curCol--;
			positions3[i] = new Pos(curRow, curCol);
		}
		// 4번 방향으로 존재하는 모든 좌표를 배열 형태로 만든다.
		Pos[] positions4 = new Pos[m4+1];
		positions4[0] = new Pos(curRow, curCol);
		for(int i = 1; i <= m4; i++) {
			curRow++;
			curCol++;
			positions4[i] = new Pos(curRow, curCol);
		}

		// 시계 방향 회전
		if (dir == 1) {
			// 1번 방향의 원소들을 시계 방향으로 회전
			int temp1 = arr[positions1[0].r][positions1[0].c];
			for (int i = 0; i < m1; i++) {
				arr[positions1[i].r][positions1[i].c] = arr[positions1[i+1].r][positions1[i+1].c];
			}
			// 2번 방향의 원소들을 시계 방향으로 회전
			for (int i = 0; i < m2; i++) {
				arr[positions2[i].r][positions2[i].c] = arr[positions2[i+1].r][positions2[i+1].c];
			}
			// 3번 방향의 원소들을 시계 방향으로 회줜
			for (int i = 0; i < m3; i++) {
				arr[positions3[i].r][positions3[i].c] = arr[positions3[i+1].r][positions3[i+1].c];
			}
			// 4번 방향의 원소등를 시계 방향으로 회전
			for (int i = 0; i < m4; i++) {
				arr[positions4[i].r][positions4[i].c] = arr[positions4[i+1].r][positions4[i+1].c];
			}

			arr[positions4[m4-1].r][positions4[m4-1].c] = temp1;
		}
		// 반시계 방향 회전
		else {
			// 1번 방향의 원소들을 반시계 방향으로 회전
			int temp1 = arr[positions1[m1].r][positions1[m1].c];
			for(int i = m1; i >= 1; i--) {
				arr[positions1[i].r][positions1[i].c] = arr[positions1[i-1].r][positions1[i-1].c];
			}
			// 2번 방향의 원소들을 반시계 방향으로 회전
			int temp2 = arr[positions2[m2].r][positions2[m2].c];
			for(int i = m2; i >= 1; i--) {
				arr[positions2[i].r][positions2[i].c] = arr[positions2[i-1].r][positions2[i-1].c];
			}

			// 3번 방향의 원소들을 반시계 방향으로 회전
			int temp3 = arr[positions3[m3].r][positions3[m3].c];
			for(int i = m3; i >= 1; i--) {
				arr[positions3[i].r][positions3[i].c] = arr[positions3[i-1].r][positions3[i-1].c];
			}
			arr[positions3[1].r][positions3[1].c] = temp3;
			// 4번 방향의 원소들을 반시계 방향으로 회전
			for(int i = m4; i >= 1; i--) {
				arr[positions4[i].r][positions4[i].c] = arr[positions4[i-1].r][positions4[i-1].c];
			}

			arr[positions2[1].r][positions2[1].c] = temp1;
			arr[positions3[1].r][positions3[1].c] = temp2;
			arr[positions4[1].r][positions4[1].c] = temp3;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m1 = Integer.parseInt(st.nextToken());
		m2 = Integer.parseInt(st.nextToken());
		m3 = Integer.parseInt(st.nextToken());
		m4 = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
	}
}

class Pos {
	int r;
	int c;

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "[" + r + ", " + c + "]";
	}
}