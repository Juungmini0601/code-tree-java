import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int a;
    public static int b;
    public static int x;
    public static int y;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        // Case1 A -> B 바로 이동
        int ans = Math.abs(a - b);
        // Case2 A -> x -> y -> B 이동
        int temp = Math.abs(a - x) + Math.abs(b - y);
        ans = Math.min(ans, temp);
        // Case3 A -> y -> x -> B 이동
        temp = Math.abs(a - y) + Math.abs(b - x);
        ans = Math.min(ans, temp);

        System.out.println(ans);
    }
}