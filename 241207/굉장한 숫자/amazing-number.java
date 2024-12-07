import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        if((n % 2 == 1 && n % 3 == 0) || (n % 2 == 0 && n % 5 == 0)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}