import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static char c;
    public static char[] arr = {'L', 'E', 'B', 'R', 'O', 'S'};

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        int k = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == c) {
                k = i;
                break;
            }
        }

        if(k == -1) {
            System.out.println("None");
        } else {
            System.out.println(k);
        }
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        c = st.nextToken().charAt(0);
    }
}