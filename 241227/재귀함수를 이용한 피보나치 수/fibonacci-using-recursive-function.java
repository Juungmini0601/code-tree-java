import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    public static int solve(int n) {
        if(n <= 2) {
            return 1;
        }

        return solve(n-1) + solve(n-2);
    }
}
