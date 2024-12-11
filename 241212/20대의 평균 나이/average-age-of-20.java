import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int sum;
    static int cnt;

    public static void main(String[] args) throws Exception {
        // input();
        solve();
    }

    public static void solve() throws Exception {
        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            if(n < 20 || n >=30) {
                double avg = (double) sum / cnt;
                System.out.printf("%.2f\n", avg);
                return;
            }

            sum += n;
            cnt++;
        }
    }

    // public static void input() throws Exception {
    //     st = new StringTokenizer(br.readLine());
    //     n = Integer.parseInt(st.nextToken());
    // }
}