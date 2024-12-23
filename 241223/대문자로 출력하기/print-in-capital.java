import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();

        for(char c: str.toCharArray()) {
            if(alphabet(c)) {
                if('a' <= c && c <= 'z') {
                    c = (char) (c - ('a' - 'A'));
                }

                System.out.print(c);
            }
        }
    }

    public static boolean alphabet(char c) {
        return ('a' <= c && c <= 'z') ||  ('A' <= c && c <= 'Z');
    }
}
