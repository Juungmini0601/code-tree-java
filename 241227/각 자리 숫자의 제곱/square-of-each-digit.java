import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int num = Integer.parseInt(br.readLine());
        System.out.println(sum(num));
    }

    public static int sum(int num) {
        if(num == 0) {
            return 0;
        }

        int x = num % 10;
        return x * x + sum(num / 10);
    }
}
