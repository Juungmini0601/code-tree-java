import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int cnt = 1;

        while(st.hasMoreTokens()) {
            if(cnt % 2 == 1) {
                System.out.println(st.nextToken());
            }
            else {
                st.nextToken();
            }
            cnt++;
        }
    }
}