import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            int sum = 0;
            double avg = 0;

            for(int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }

            avg = (double) sum / 4;

            if(avg >= 60) {
                System.out.println("pass");
                cnt++;
            } else {
                System.out.println("fail");
            }
        }

        System.out.println(cnt);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }
}