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
        int c = Integer.parseInt(st.nextToken());

        int min = a;
        min = Math.min(min, b);
        min = Math.min(min, c);

        if(min == a) {
            System.out.print(1 + " ");
        } else {
            System.out.print(0 + " ");
        }

        if(a == b && b == c) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}