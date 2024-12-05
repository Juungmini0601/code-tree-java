import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(), "-");
        String a = st.nextToken();
        String b = st.nextToken();
        String c = st.nextToken();

        System.out.printf("%s-%s-%s", a, c, b);
    }
}