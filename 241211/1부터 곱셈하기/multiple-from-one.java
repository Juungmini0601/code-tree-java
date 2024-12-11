import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int mul = 1;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() {
        sb = new StringBuilder();

        for(int i = 1; i <= 10; i++) {
            mul *= i;
            if(mul >= n) {
                sb.append(i);
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