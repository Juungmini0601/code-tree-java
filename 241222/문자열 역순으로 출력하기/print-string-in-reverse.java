import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static String[] strs = new String[4];

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();

        for(int i = 3; i >= 0; i--) {
            sb.append(strs[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        for(int i = 0; i < 4; i++) {
            strs[i] = br.readLine();
        }
    }
}