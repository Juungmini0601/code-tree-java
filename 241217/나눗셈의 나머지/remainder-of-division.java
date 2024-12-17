import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int a;
    public static int b;
    public static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        StringBuilder sb = new StringBuilder();
        
        while(a > 1) {
            arr[a % b]++;
            a /= b;
        }

        int sum = 0;

        for (int i = 0; i <= 9; i++) {
            sum += arr[i] * arr[i];
        }

        System.out.println(sum);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }
}