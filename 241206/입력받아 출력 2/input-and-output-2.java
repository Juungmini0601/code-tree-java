import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(), "-");
        int f = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        System.out.printf("%d%d", f, t);
    }
}