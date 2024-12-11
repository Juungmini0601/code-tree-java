import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int y = 1 ; y <= n; y++) {
            if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}