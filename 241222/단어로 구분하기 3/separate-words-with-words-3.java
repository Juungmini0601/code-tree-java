import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String[] strs = new String[10];
        st = new StringTokenizer(br.readLine());

        int i = 0;
        while(st.hasMoreTokens()) {
            strs[i] = st.nextToken();
            i++;
        }

        for(int j = 9; j >= 0; j--) {
            System.out.println(strs[j]);
        }
    }
}