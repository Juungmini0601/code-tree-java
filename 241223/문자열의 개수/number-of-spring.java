import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals("0")) break;

            cnt++;
            if(cnt % 2 == 1) {
                sb.append(str).append("\n");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}
