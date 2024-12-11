import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int a;
    static int b;
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() {
        for(int i = a; i <= b; i++) {
            answer *= i;
        }

        System.out.println(answer);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }
}