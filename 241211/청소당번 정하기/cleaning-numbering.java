import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt2 = 0;
        int cnt3 = 0;
        int cnt12 = 0;

        for(int i = 1; i <= n; i++) {
            if(i % 12 == 0) {
                cnt12++;
            }
            else if(i % 3 == 0) {
                cnt3++;
            }
            else if(i % 2 == 0) {
                cnt2++;
            }
        }

        System.out.println(cnt2 + " " + cnt3 + " " + cnt12);
    }
}