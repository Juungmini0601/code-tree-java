import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a / b);
        System.out.println(a % b);
    }
}