import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String c = st.nextToken();

        int index = s.indexOf(c);

        if(index == -1) {
            System.out.println("No");
        }
        else {
            System.out.println(index);
        }
    }
}