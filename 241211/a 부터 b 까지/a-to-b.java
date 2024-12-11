import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int num = a;

        while(num <= b) {
            sb.append(num + " ");
            
            if(num % 2 == 1) {
                num *= 2;
            } else {
                num += 3;
            }
        }

        System.out.println(sb);
    }
}