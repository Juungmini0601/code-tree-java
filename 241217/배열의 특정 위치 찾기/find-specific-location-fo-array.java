import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] arr = new int[11];

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        int sum1 = 0;
        int sum2 = 0;
        int cnt = 0;

        for(int i = 1; i <= 10; i++) {
            if(i % 2 == 0) {
                sum1 += arr[i];
            }

            if(i % 3 == 0) {
                sum2 += arr[i];
                cnt++;
            }
        }

        double avg = (double) sum2 / cnt;
        System.out.printf("%d %.1f", sum1, avg);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
    
        for(int i = 1; i <= 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}