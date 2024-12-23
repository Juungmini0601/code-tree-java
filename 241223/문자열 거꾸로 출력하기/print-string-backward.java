import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        while(true) {
            String str = br.readLine();
            if(str.equals("END")) break;
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse().toString());
        }
    }
}
