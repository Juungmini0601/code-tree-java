import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int num1 = convert(st.nextToken());
        int num2 = convert(st.nextToken());

        System.out.println(num1 + num2);
    }

    public static int convert(String str) {
        String ret = "";

        for(char c :str.toCharArray()) {
            if('0' <= c && c <= '9') {
                ret += c;
            } else {
                break;
            }
        }

        return Integer.parseInt(ret);
    }
}
