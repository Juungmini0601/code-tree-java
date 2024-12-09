import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {        
        st = new StringTokenizer(br.readLine());
        String c = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        if(c.equals("A")) {
            for(int i = 1; i <= n; i++) {
                sb.append(i + " ");
            }
        } else {
            for(int i = n; i >= 1; i--) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }
}