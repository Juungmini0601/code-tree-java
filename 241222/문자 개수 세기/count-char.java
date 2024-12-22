import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static String str;
    public static char c;

    public static void main(String[] args) throws Exception {
        input();
        int cnt = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void input() throws Exception {
        str = br.readLine();
        c = br.readLine().charAt(0);
    }
}