import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        char cur = str.charAt(0);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(cur);

        for(int i = 1; i < str.length(); i++) {
            char nextChar = str.charAt(i);

            if(nextChar == cur) {
                cnt++;
                continue;
            }
            sb.append(cnt);
            sb.append(nextChar);
            cur = nextChar;
            cnt = 1;
        }

        sb.append(cnt);
        System.out.println(sb.toString().length());
        System.out.println(sb);
    }
}