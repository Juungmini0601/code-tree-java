import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int cnt;

    public static void main(String[] args) throws Exception {
        // input();
        solve();
    }

    public static void solve() throws Exception {
        sb = new StringBuilder();

        while(cnt < 3) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            if(n % 2 == 0) {
                sb.append(n / 2).append("\n");
                cnt++;
            }
        }

        System.out.println(sb);
    }

    // public static void input() throws Exception {
    //     st = new StringTokenizer(br.readLine());
    //     n = Integer.parseInt(st.nextToken());
    // }
}