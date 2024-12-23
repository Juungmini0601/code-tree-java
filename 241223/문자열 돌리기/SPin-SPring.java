import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int len = str.length();

        for(int i = 1; i <= len + 1; i++) {
            System.out.println(str);
            str = str.substring(str.length()-1) + str.substring(0, str.length()-1);
        }
    }
}
