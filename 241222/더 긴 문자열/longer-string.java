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
        if(str1.length() > str2.length()) {
            System.out.println(str1 + " " + str1.length());
        }
        else if(str1.length() < str2.length()) {
            System.out.println(str2 + " " + str2.length());
        }
        else {
            System.out.println("same");
        }
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        str1 = st.nextToken();
        str2 = st.nextToken();
    }
}