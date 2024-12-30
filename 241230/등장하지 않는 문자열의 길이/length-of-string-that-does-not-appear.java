import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static String str;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        str = br.readLine();

        for(int len = 1; len <= n; len++) {
            // System.out.println("길이가 " + len + "인 부분 문자열");
            String substring = str.substring(0, len);
            int cnt = count(substring);
            // System.out.println(substring + " " + cnt);

            if(cnt < 2) {
                System.out.println(len);
                return;
            }
            
        }
    }

    public static int count(String substring) {
        int cnt = 0;
        int len = substring.length();

        for(int i = 0; i <= n - len; i++) {
            String temp = str.substring(i, i + len);
            
            if(temp.equals(substring)) {
                cnt++;
            }
        }

        return cnt;
    }
}