import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int sum = 0;

        for(char c: str.toCharArray()) {
            if(number(c)) {
                sum += c - '0';
            }
        }

        System.out.println(sum);
    }

    public static boolean number(char c) {
        return '0' <= c && c <= '9';
    }
}
