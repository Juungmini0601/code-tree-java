import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0 || i % 3 == 0) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}