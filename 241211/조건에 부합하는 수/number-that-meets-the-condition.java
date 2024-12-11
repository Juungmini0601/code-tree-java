import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int cnt;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() {
        sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0 && i % 4 != 0) {
                continue;
            }

            if((i / 8) % 2 == 0) {
                continue;
            }

            if(i % 7 < 4) {
                continue;
            }

            sb.append(i + " ");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }
}