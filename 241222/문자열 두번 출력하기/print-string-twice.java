import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static String str;

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("\n").append(str);
        System.out.println(sb);
    }

    public static void input() throws Exception {
        str = br.readLine();
    }
}