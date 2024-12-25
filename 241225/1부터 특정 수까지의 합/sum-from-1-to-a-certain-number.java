import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        System.out.println(calcSum(n));
    }

    public static int calcSum(int n) {
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum / 10;
    }
}