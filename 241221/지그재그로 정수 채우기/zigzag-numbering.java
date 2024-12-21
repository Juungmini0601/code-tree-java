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
        int cnt = 0;

        for(int col = 0; col < m; col++) {
            if(col % 2 == 0) {
                for(int row = 0; row < n; row++) {
                    arr[row][col] = cnt;
                    cnt++;
                }
            } else {
                for(int row = n - 1; row >= 0; row--) {
                    arr[row][col] = cnt;
                    cnt++;
                }
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