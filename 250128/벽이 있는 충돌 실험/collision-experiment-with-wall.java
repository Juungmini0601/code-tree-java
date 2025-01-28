import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 코테 풀이용 코드
public class Main {

	public static int t;
	public static int n;
	public static int m;
	public static int[][] arr;
	public static Pos[][] posArr;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			input();

			for (int j = 0; j < 10; j++) {
				move();
			}

			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (arr[j][k] == 1) {
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	private static void printArr() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Pos 배열로 표현하면 구슬이 겹치는 거를 판단하기가 까다롭다.
	// int 배열로 표현하면 구슬의 방향정보를 가지기가 어렵다.
	private static void move() {
		int[][] nextArr = new int[n + 1][n + 1];
		Pos[][] nextPosArr = new Pos[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] != 1)
					continue;
				// 구슬을 새로운 배열에 움직이도록 표시한다.
				String dir = posArr[i][j].dir;
				int nx = i;
				int ny = j;
				// 방향에 따라서 좌표를 이동 시켜본다.
				switch (dir) {
					case "U":
						nx--;
						break;
					case "D":
						nx++;
						break;
					case "L":
						ny--;
						break;
					case "R":
						ny++;
						break;
				}
				// 만일 좌표에 따라 이동 시켰는데 배열 바깥으로 나간 경우
				if (nx < 1 || nx > n || ny < 1 || ny > n) {
					// 좌표를 이동시키지 않고 반대 방향으로 바꿔준다.
					switch (posArr[i][j].dir) {
						case "U":
							posArr[i][j].dir = "D";
							break;
						case "D":
							posArr[i][j].dir = "U";
							break;
						case "L":
							posArr[i][j].dir = "R";
							break;
						case "R":
							posArr[i][j].dir = "L";
							break;
					}
					nextArr[i][j] = arr[i][j];
					nextPosArr[i][j] = posArr[i][j];
				} else {
					// 이동 시켜준다.
					nextArr[nx][ny] += 1;
					nextPosArr[nx][ny] = new Pos(nx, ny, dir);
					arr[i][j] -= 1;
					posArr[i][j] = null;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] >= 2) {
					arr[i][j] = 0;
					posArr[i][j] = null;
					continue;
				}

				arr[i][j] = nextArr[i][j];
				posArr[i][j] = nextPosArr[i][j];
			}
		}
	}

	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][n + 1];
		posArr = new Pos[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();

			arr[x][y] = 1;
			posArr[x][y] = new Pos(x, y, dir);
		}
	}
}

class Pos {
	int x;
	int y;
	String dir;

	public Pos(int x, int y, String dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}


