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
        int answer = str1.length() + str2.length();
        System.out.println(answer);
    }

    public static void input() throws Exception {
        str1 = br.readLine();
        str2 = br.readLine();
    }
}