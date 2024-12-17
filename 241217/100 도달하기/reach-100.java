import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr = new int[100];

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ").append(arr[1]).append(" ");
        int curIndex = 2;

        while(true) {
            arr[curIndex] = arr[curIndex-1] + arr[curIndex-2];
            sb.append(arr[curIndex]).append(" ");

            if(arr[curIndex] > 100) {
                break;
            }

            curIndex++;
        }

        System.out.println(sb);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr[0] = 1;
        arr[1] = n;
    }
}