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
        
        System.out.println(a >= b ? 1 : 0);
        System.out.println(a > b ? 1 : 0);
        System.out.println(b >= a ? 1 : 0);
        System.out.println(b > a ? 1 : 0);
        System.out.println(a == b ? 1 : 0);
        System.out.println(a != b ? 1 : 0);
    }
}