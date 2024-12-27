import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        System.out.println(sum(n));
    }

    public static int sum(int n) {
        if(n <= 0) {
            return 0;
        }

        return n + sum(n-2);
    }
}
