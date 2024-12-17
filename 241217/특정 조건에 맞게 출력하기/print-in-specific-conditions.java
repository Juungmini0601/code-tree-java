import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] arr = new int[100];

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        StringBuilder sb = new StringBuilder();
        int curIndex = 0;

        while(arr[curIndex] != 0) {
            int num = arr[curIndex];
            
            if(num % 2 == 0) {
                sb.append(num / 2).append(" ");
            } else {
                sb.append(num + 3).append(" ");
            }
            
            curIndex++;
        }

        System.out.println(sb);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        int curIndex = 0;

        while(st.hasMoreTokens()) {
            arr[curIndex++] = Integer.parseInt(st.nextToken());
            if(arr[curIndex - 1] == 0) {
                break;
            }
        }
    }
}