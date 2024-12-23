import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();

        for(char c : str.toCharArray()) {
            if('a' <= c && c <= 'z') {
                c = (char) (c - ('a' - 'A'));
            } else if('A' <= c && c <= 'Z') {
                c = (char) (c - ('A' - 'a'));
            }

            System.out.print(c);
        }
    }
}
