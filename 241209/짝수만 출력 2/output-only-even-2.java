import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {        
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int i = b;

        while(i >= a) {
            System.out.print(i + " ");
            i -= 2;
        }
    }
}