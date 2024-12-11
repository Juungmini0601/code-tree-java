import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        sb = new StringBuilder();

        while(true) {
            if(n == 1) {
                break;
            }

            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            cnt++;
        }
        
        sb.append(cnt);

        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }
}