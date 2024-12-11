import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        sb = new StringBuilder();
        // c의 배수가 없다
        boolean isPrime = true;

        for(int i = 2; i <= n-1; i++) {
            if(n % i == 0) {
                isPrime = false;
                break;
            }
        }

        sb.append(isPrime ? "P" : "C");

        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }
}