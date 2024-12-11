import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws Exception {
        // input();
        solve();
    }

    public static void solve() throws Exception {
        sb = new StringBuilder();
        // c의 배수가 없다
        boolean isAll3Mul = true;

        for(int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            if(num % 3 != 0) {
                isAll3Mul = false;
                break;
            }
        }

        sb.append(isAll3Mul ? "1" : "0");

        System.out.println(sb);
    }

    // public static void input() throws Exception {
    //     st = new StringTokenizer(br.readLine());
    //     n = Integer.parseInt(st.nextToken());
    // }
}