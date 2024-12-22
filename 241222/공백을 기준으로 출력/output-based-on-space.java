import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static String str1;
    public static String str2;

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != ' ') {
                sb.append(str1.charAt(i));
            }
        }

        for(int i = 0; i < str2.length(); i++) {
            if(str2.charAt(i) != ' ') {
                sb.append(str2.charAt(i));
            }
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        str1 = br.readLine();
        str2 = br.readLine();
    }
}