import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        String temp = "";

        while(st.hasMoreTokens()) {
            temp += st.nextToken();
        }

        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < temp.length(); i++) {
            sb.append(temp.charAt(i));
            if(cnt % 5 == 0) {
                sb.append("\n");
            }
            cnt++;
        }

        System.out.println(sb);
    }
}