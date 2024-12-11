import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a <= 0) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< b; i++) {
                sb.append(a + "");
            }
            System.out.println(sb);
        }
    }
}