import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[][] arr;

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        boolean bottomToTop = true;

        for(int col = n-1; col >= 0; col--) {
            if(bottomToTop) {
                for(int row = n-1; row >= 0; row--) {
                    arr[row][col] = cnt;
                    cnt++;
                }
            }
            else {
                for(int row = 0; row < n; row++) {
                    arr[row][col] = cnt;
                    cnt++;
                }
            }
            
            bottomToTop = !bottomToTop;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
    }
}