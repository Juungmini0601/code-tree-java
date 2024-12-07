import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {        
        int cnt = 0;

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            
            char c = st.nextToken().charAt(0);
            int temp = Integer.parseInt(st.nextToken());

            if(check(c, temp)) {
                cnt++;
            }
        }

        if(cnt >= 2) {
            System.out.println("E");
        } 
        else {
            System.out.println("N");
        }
    }

    public static boolean check(char c, int temp) {
        return c == 'Y' && temp >= 37;
    }
}