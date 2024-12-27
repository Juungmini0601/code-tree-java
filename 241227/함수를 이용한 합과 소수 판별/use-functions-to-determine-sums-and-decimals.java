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

        int cnt = 0;

        for(int i = a; i <= b; i++) {
            if(isPrime(i) && sumN(i) % 2 == 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean isPrime(int n) {
        if(n == 1) return false;

        for(int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }

    public static int sumN(int n) {
        String strN = "" + n;
        int ans = 0;

        for(char c: strN.toCharArray()) {
            ans += c - '0';
        }

        return ans;
    }
}
