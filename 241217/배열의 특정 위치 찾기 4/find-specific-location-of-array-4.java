import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < 10; i++) {
            if(arr[i] == 0) {
                break;
            }

            if(arr[i] % 2 == 0) {
                sum += arr[i];
                cnt++;
            }
        }

        System.out.printf("%d %d\n", cnt, sum);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}