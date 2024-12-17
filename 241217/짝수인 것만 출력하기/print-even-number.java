import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                break;
            }

            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int curIndex = 0;

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if(num % 2 == 0) {
                arr[curIndex++] = num;
            }
        }
    }
}