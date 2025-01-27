import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 코테 풀이용 코드
public class Main {

	public static final int EMPTY = 0;
	public static final int TYPE1 = 1; // / 모양 막대
	public static final int TYPE2 = 2; // \ 모양 막대
	public static final String LEFT = "L";
	public static final String RIGHT = "R";
	public static final String UP = "U";
	public static final String DOWN = "D";
	public static int n;
	public static int[][] arr;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		int maxTime = 0;
		int maxN = 4 * n;

		for(int i = 1; i <= maxN; i++) {
			String dir = "";
			int curX;
			int curY;

			if(i <= n) {
				dir = DOWN;
				curX = 1;
				curY = i;
			}
			else if (i <= 2 * n) {
				dir = LEFT;
				curX = i - n;
				curY = n;
			}
			else if (i <= 3 * n) {
				dir = UP;
				curX = n;
				curY = 3 * n + 1 - i;
			}
			else {
				dir = RIGHT;
				curX = 4 * n + 1 - i;
				curY = 1;
			}

			int time = game(curX, curY, dir);
			maxTime = Math.max(maxTime, time);
		}

		System.out.println(maxTime);
	}

	private static int game(int curX, int curY, String dir) {
		int x = curX;
		int y = curY;
		int time = 1;

		while(inRange(x, y)) {
			if(arr[x][y] == TYPE1) {
				// / 모양 막대인 경우
				// 1. 오른쪽으로 가는 방향은 위쪽으로 바꾼다.
				if(dir.equals(RIGHT)) {
					dir = UP;
				}
				// 2. 왼쪽으로 가는 방향은 아래쪽으로 바꾼다.
				else if (dir.equals(LEFT)) {
					dir = DOWN;
				}
				// 3. 아래쪽으로 가는 방향은 왼쪽으로 바꾼다.
				else if(dir.equals(DOWN)) {
					dir = LEFT;
				}
				// 4. 위쪽으로 가는 방향은 오른쪽으로 바꾼다.
				else {
					dir = RIGHT;
				}
			}
			else if(arr[x][y] == TYPE2) {
				// \ 방향 막대인 경우
				// 1. 오른쪽으로 가는 방향은 아래 쪽으로 바꾼다.
				if (dir.equals(RIGHT)) {
					dir = DOWN;
				}
				// 2. 왼쪽으로 가는 방향은 위쪽으로 바꾼다.
				else if (dir.equals(LEFT)) {
					dir = UP;
				}
				// 3. 아래쪽으로 가는 방향은 오른쪽으로 바꾼다.
				else if (dir.equals(DOWN)) {
					dir = RIGHT;
				}
				// 4. 위쪽으로 가는 방향은 왼쪽으로 바꾼다.
				else {
					dir = LEFT;
				}
			}

			int[] nextPos = move(x, y, dir);
			x = nextPos[0];
			y = nextPos[1];
			time++;
		}

		return time;
	}

	private static int[] move(int x, int y, String dir) {
		int[] nextPos = new int[2];

		if(dir.equals(LEFT)) {
			nextPos[0]= x;
			nextPos[1]= y-1;
		}
		else if(dir.equals(RIGHT)) {
			nextPos[0]= x;
			nextPos[1]= y + 1;
		}
		else if(dir.equals(UP)) {
			nextPos[0]= x - 1 ;
			nextPos[1]= y;
		}
		else {
			// 아래
			nextPos[0]= x + 1;
			nextPos[1]= y;
		}

		return nextPos;
	}

	private static boolean inRange(int x, int y) {
		return x >= 1 && x <= n && y >= 1 && y <= n;
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
