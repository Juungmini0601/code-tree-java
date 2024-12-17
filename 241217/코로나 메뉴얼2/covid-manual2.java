import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr = new int[4];

    public static void main(String[] args) throws Exception {
        // input();
        solve();
    }

    public static void solve() throws Exception {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            String yn = st.nextToken();
            int temperature = Integer.parseInt(st.nextToken());
            arr[check(yn, temperature)]++;
        }

        for(int i = 0; i < 4; i++) {
            sb.append(arr[i]).append(" ");
        }

        if(arr[0] >= 2) {
            sb.append("E");
        }

        System.out.println(sb);
    }   

    public static int check(String YN, int temperature) {
        if(YN.equals("Y") && temperature >= 37) {
            return 0;
        }
        else if(YN.equals("N") && temperature >= 37) {
            return 1;
        }
        else if(YN.equals("Y") && temperature < 37) {
            return 2;
        }
        else {
            return 3;
        }
    }
}