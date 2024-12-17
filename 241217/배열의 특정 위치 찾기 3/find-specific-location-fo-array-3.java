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
        int findIndex = -1;

        for(int i = 0; i < 100; i++) {
            if(arr[i] == 0) {
                findIndex = i;
                break;
            }
        }

        int sum = arr[findIndex-1] + arr[findIndex-2] + arr[findIndex-3];
        System.out.println(sum);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        int i = 0;

        while(st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
    }
}