import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            char c = (char) Integer.parseInt(st.nextToken());
            System.out.print(c + " ");
        }
    }
}
