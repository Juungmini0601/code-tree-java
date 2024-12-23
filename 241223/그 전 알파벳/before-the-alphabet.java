import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        char c = br.readLine().charAt(0);
        char next = (char)(c - 1);

        if(next < 'a') {
            next = 'z';
        }

        System.out.println(next);
    }
}
