import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr = new int[11];

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for(int i = 0; i < 10; i++) {
            arr[i] = n * (i + 1);
            sb.append(arr[i]).append(" ");

            if(arr[i] % 5 == 0) {    
                cnt++;
            }

            if(cnt >= 2) {
                break;
            }
        }

        System.out.println(sb);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }
}