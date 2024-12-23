import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String a = br.readLine();
        String b = br.readLine();
        int cnt = 0;

        for(int i = 0; i < a.length(); i++) {
            a = a.charAt(a.length() - 1) + a.substring(0, a.length() - 1);
            cnt++;

            if(a.equals(b)) {
                System.out.println(cnt);
                System.exit(0);
            }
        }

        System.out.println(-1);
    }
}
