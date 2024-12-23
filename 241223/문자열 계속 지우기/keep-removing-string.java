import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String a = br.readLine();
        String b = br.readLine();

        while(true) {
            int index = a.indexOf(b);
            if(index == -1) break;
            a = a.substring(0, index) + a.substring(index + b.length());
        }

        System.out.println(a);
    }
}
