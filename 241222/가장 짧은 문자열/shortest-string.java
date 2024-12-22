import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static String str1;
    public static String str2;
    public static String str3;

    public static void main(String[] args) throws Exception {
        input();
        int min = str1.length();
        int max = str1.length();

        min = Math.min(min, str2.length());
        min = Math.min(min, str3.length());
        max = Math.max(max, str2.length());
        max = Math.max(max, str3.length());

        System.out.println(max - min);
    }

    public static void input() throws Exception {
        str1 = br.readLine();
        str2 = br.readLine();
        str3 = br.readLine();
    }
}