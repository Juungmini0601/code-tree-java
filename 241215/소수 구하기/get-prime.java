import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
           if(isPrime(i)) {
             sb.append(i + " ");
           }
        }
        
        System.out.println(sb);
    }

    public static boolean isPrime(int x) {
        if(x == 1) return false;

        for(int i = 2; i < x; i++) {
            if(x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }
}