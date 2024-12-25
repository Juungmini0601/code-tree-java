import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i = a; i <= b; i++) {
            if(i % 3 == 0 || check369(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean check369(int num) {
        String numString = "" + num;

        for(char c: numString.toCharArray()) {
            if(c == '3' || c == '6' || c == '9') return true;
        }

        return false;
    }
}
