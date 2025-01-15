import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr = new int[4][4];
	public static String dir;
	public static final int BLANK = 0;

	// 이동 방향에 0이 없도록 모두 이동 시킨 후 합친다.
	public static void main(String[] args) throws Exception {
		input();

		if (dir.equals("U")) {
			moveUp();
		} else if (dir.equals("D")) {
			moveDown();
		} else if (dir.equals("R")) {
			moveRight();
		} else if (dir.equals("L")) {
			moveLeft();
		}

		printArr();
	}

	public static void moveUp() {
		// 이동 방향에 0이 없도록 모두 이동시킨다.
		int[][] temp = new int[4][4];

		for (int col = 0; col < 4; col++) {
			int tempIndex = 0;

			for (int row = 0; row <= 3; row++) {
				if (arr[row][col] != BLANK) {
					temp[tempIndex][col] = arr[row][col];
					tempIndex++;
				}
			}
		}

		arr = temp;
		// 끝 방향에서 값이 같은 친구들을 합쳐서 이동 시킨다.
		for (int col = 0; col < 4; col++) {
			for (int row = 0; row <= 2; row++) {
				if (arr[row][col] != BLANK && arr[row][col] == arr[row + 1][col]) {
					arr[row][col] += arr[row + 1][col];
					arr[row + 1][col] = BLANK;
				} else if (arr[row][col] == BLANK) {
					arr[row][col] = arr[row + 1][col];
					arr[row + 1][col] = BLANK;
				}
			}
		}
	}

	public static void moveDown() {
		int[][] temp = new int[4][4];
		for (int col = 0; col < 4; col++) {
			int tempIndex = 3;

			for (int row = 3; row >= 0; row--) {
				if (arr[row][col] != BLANK) {
					temp[tempIndex][col] = arr[row][col];
					tempIndex--;
				}
			}
		}

		arr = temp;

		for (int col = 0; col < 4; col++) {
			for (int row = 3; row >= 1; row--) {
				if (arr[row][col] != BLANK && arr[row][col] == arr[row - 1][col]) {
					arr[row][col] += arr[row - 1][col];
					arr[row - 1][col] = BLANK;
				} else if (arr[row][col] == BLANK) {
					arr[row][col] = arr[row - 1][col];
					arr[row - 1][col] = BLANK;
				}
			}
		}
	}

	public static void moveRight() {
		// 이동 방향에 0이 없도록 모두 이동 시킨다.
		int[][] temp = new int[4][4];

		for (int row = 0; row < 4; row++) {
			int tempIndex = 3;

			for (int col = 3; col >= 0; col--) {
				if (arr[row][col] != BLANK) {
					temp[row][tempIndex] = arr[row][col];
					tempIndex--;
				}
			}
		}

		arr = temp;
		// 끝 방향에서 값이 같은 친구들을 합쳐서 이동 시킨다.
		for (int row = 0; row < 4; row++) {
			for (int col = 3; col >= 1; col--) {
				if (arr[row][col] != BLANK && arr[row][col - 1] == arr[row][col]) {
					arr[row][col] += arr[row][col - 1];
					arr[row][col - 1] = 0;
				} else if (arr[row][col] == BLANK) {
					arr[row][col] = arr[row][col - 1];
					arr[row][col - 1] = BLANK;
				}
			}
		}
	}

	public static void moveLeft() {
		// 이동 방향에 0이 없도록 모두 이동 시킨다.
		int[][] temp = new int[4][4];

		for (int row = 0; row < 4; row++) {
			int tempIndex = 0;

			for (int col = 0; col <= 3; col++) {
				if (arr[row][col] != BLANK) {
					temp[row][tempIndex] = arr[row][col];
					tempIndex++;
				}
			}
		}

		arr = temp;
		// 끝 방향에서 값이 같은 친구들을 합쳐서 이동 시킨다.
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col <= 2; col++) {
				if (arr[row][col] != BLANK && arr[row][col] == arr[row][col + 1]) {
					arr[row][col] += arr[row][col + 1];
					arr[row][col + 1] = 0;
				} else if (arr[row][col] == BLANK) {
					arr[row][col] = arr[row][col + 1];
					arr[row][col + 1] = BLANK;
				}
			}
		}
	}

	public static void printArr() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void input() throws Exception {
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dir = br.readLine();
	}
}

