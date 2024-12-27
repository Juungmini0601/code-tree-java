import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        boolean ans = str.equals(reverse(str));
        System.out.println(ans ? "Yes" : "No");
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
