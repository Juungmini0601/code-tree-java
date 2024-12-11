import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        // input();
        solve();
    }

    public static void solve() throws Exception {
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            if(n == 1) {
                sb.append("John\n");
            }
            else if(n == 2) {
                sb.append("Tom\n");
            }
            else if(n == 3) {
                sb.append("Paul\n");  
            }
            else if(n == 4) {
                sb.append("Sam\n");
            }
            else {
                sb.append("Vacancy\n");
                break;
            }
        }

        System.out.println(sb);
    }

    // public static void input() throws Exception {
    //     st = new StringTokenizer(br.readLine());
    //     n = Integer.parseInt(st.nextToken());
    // }
}