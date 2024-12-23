import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        String str = "" + sum;

        System.out.println(str.substring(1) + str.charAt(0));
    }
}
