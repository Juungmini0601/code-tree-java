import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            if(check(i)) {
                sb.append("0 ");
            } else {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    public static boolean check(int num) {
        if(num % 3 == 0) {
            return true;
        }

        while(num != 0) {
            int x = num % 10;
            num /= 10;

            if(x == 3 || x == 6 || x == 9) {
                return true;
            }
        }

        return false;
    }
}