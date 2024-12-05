import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static double a;
    static double b;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        b = Double.parseDouble(st.nextToken());

        System.out.printf("%.2f\n", a + b);
    }
}