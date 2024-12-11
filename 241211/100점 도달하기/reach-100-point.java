import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i = n; i <= 100; i++) {
            if(i >= 90) {
                sb.append("A ");
            }
            else if(i >= 80) {
                sb.append("B ");
            }
            else if(i >= 70) {
                sb.append("C ");
            }
            else if(i >= 60) {
                sb.append("D ");
            }
            else {
                sb.append("F ");
            }
        }

        System.out.println(sb);
    }
}