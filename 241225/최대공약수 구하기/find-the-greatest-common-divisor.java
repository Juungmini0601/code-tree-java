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
        int ret = 1;
        int min = Math.min(n, m);

        for(int i = 1; i <= min; i++) {
            if(n % i == 0 && m % i == 0) {
                ret = i;
            }
        }

        System.out.println(ret);
    }
}