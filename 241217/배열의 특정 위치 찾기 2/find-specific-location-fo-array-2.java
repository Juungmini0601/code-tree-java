import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        int sumOdd = 0;
        int sumEven = 0;

        for(int i = 0; i < 10; i++) {
            if(i % 2 == 0) {
                sumOdd += arr[i];
            } else {
                sumEven += arr[i];
            }
        }

        System.out.println(Math.max(sumEven, sumOdd) - Math.min(sumEven, sumOdd));
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
    
        for(int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}