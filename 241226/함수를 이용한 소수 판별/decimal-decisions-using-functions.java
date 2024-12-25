import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int sum = 0;

        for(int i = a; i <= b; i++) {
            if(isPrime(i)) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

    public static boolean isPrime(int num) {
        if(num == 1) {
            return false;
        }

        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}
