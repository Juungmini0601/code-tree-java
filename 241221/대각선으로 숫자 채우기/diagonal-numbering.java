import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int m;
    public static int[][] arr;

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        // col에서 시작한 대각선을 기준으로 먼저 칸을 채운다.
        for(int col = 0; col < m; col++) {
            int curCol = col;
            int curRow = 0;

            while(curRow < n && curCol >= 0) {
                arr[curRow][curCol] = cnt;
                cnt++;
                curRow++;
                curCol--;
            }
        }

        // 1, m-1에서 시작한 대각선을 기준으로 칸을 채운다.
        for(int row = 1; row < n; row++) {
            int curCol = m-1;
            int curRow = row;

            while(curRow < n && curCol >= 0) {
                arr[curRow][curCol] = cnt;
                cnt++;
                curRow++;
                curCol--;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
    }
}