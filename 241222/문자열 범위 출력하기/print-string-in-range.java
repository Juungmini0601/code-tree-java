import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static String str;

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(str.substring(2,10));
    }

    public static void input() throws Exception {
        str = br.readLine();
    }
}