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
        
        if((b < a && a < c) || (c < a && a < b)) {
            System.out.println(a);
        }
        else if((a < b && b < c) || (c < b && b < a)) {
            System.out.println(b);
        }
        else {
            System.out.println(c);
        }
    }

}