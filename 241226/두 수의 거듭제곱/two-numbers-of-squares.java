import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        pow(a, b);
    }

    public static void pow(int a, int b) {
        int ret = 1;

        for(int i = 0; i < b; i++) {
            ret *= a;
        }

        System.out.println(ret);
    }
}
