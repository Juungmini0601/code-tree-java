import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < q; i++) {
            int command = Integer.parseInt(br.readLine());

            if(command == 1) {
                str = str.substring(1) + str.substring(0, 1);
            }
            else if (command == 2) {
                str = str.substring(str.length()-1) + str.substring(0, str.length() - 1);
            }
            else {
                StringBuilder sb = new StringBuilder(str);
                str = sb.reverse().toString();
            }

            System.out.println(str);
        }
    }
}
