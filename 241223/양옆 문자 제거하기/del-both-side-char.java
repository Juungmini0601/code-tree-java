import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        str = str.substring(0, 1) + str.substring(2);
        int length = str.length();
        str = str.substring(0, length - 2) + str.substring(length-1);

        System.out.println(str);
    }
}