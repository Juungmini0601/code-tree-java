import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solve(n, m);
    }

    public static void solve(int n, int m) {
        int ret = Math.max(n, m);

        while(true) {
            if(ret % n == 0 && ret % m == 0) {
                System.out.println(ret);
                return;
            }
            ret++;
        }
    }
}