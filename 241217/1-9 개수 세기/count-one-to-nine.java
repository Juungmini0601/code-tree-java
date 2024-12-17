import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num]++;
        }

        for(int i = 1; i <= 9; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }
}