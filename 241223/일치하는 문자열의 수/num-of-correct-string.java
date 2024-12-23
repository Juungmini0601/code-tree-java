import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            String input = br.readLine();

            if(input.equals(str)) cnt++;
        }

        System.out.println(cnt);
    }
}
