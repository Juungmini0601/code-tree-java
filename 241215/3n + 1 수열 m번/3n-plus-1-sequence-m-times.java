import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int m;
    public static int n;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= m; i++) {
            n = Integer.parseInt(br.readLine());
            int cnt = 0;

            while(n != 1) {
                if(n % 2 == 0) {
                    n /= 2;
                } else {
                    n = 3 * n + 1;
                }
                cnt++;
            }

            sb.append(cnt + "\n");
        }
        
        System.out.println(sb);
    }

    public static void input() throws Exception {
        m = Integer.parseInt(br.readLine());
    }
}