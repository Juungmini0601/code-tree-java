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
            if(condition(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean condition(int num) {
        if(num % 2 == 0) return false;
        if(num % 10 == 5) return false;
        if(num % 3 == 0 && num % 9 != 0) return false;
        return true;
    }
}
