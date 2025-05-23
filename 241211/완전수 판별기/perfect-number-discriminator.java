import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = 0;

        for(int i = 1 ; i < n; i++) {
            if(n % i == 0) {
                sum += i;
            }
        }

        System.out.println(n == sum ? "P" : "N");
    }

}