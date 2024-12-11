import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= (n + 1) - i; j++) {
                sb.append(star((n+1) - i)).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }

    public static String star(int x) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= x; i++) {
            sb.append("*");
        }

        return sb.toString();
    }
}