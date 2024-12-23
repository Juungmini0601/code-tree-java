import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        char c1 = st.nextToken().charAt(0);
        char c2 = st.nextToken().charAt(0);

        int sum = (int) (c1 + c2);
        int diff = Math.abs((int) (c1 - c2));

        System.out.printf("%d %d", sum, diff);
    }
}
