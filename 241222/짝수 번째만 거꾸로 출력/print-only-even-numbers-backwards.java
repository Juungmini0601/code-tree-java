import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < str.length(); i+=2) {
            sb.append(str.charAt(i));
        }

        String reverse = sb.toString();

        for(int i = reverse.length() - 1; i >= 0; i--) {
            System.out.print(reverse.charAt(i));
        }
    }
}