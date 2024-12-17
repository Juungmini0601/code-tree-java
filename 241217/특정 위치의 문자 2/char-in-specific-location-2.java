import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static char[] arr = new char[10];

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        String ans = "" + arr[1] + " " + arr[4] + " " + arr[7];
        System.out.println(ans);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
    
        for(int i = 0; i < 10; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
    }
}