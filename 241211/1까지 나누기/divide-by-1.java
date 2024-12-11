import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int num = 1;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() {
        sb = new StringBuilder();

        while(true) {
            n /= num;
            cnt++;

            if(n <= 1) {
                break;
            }

            num++;
        }

        sb.append(cnt);

        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }
}