import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        
        if(y % 4 == 0) {
            if(y % 100 == 0 && y % 400 != 0) {
                System.out.println("false");
            }
            else {
                System.out.println("true");
            }
        }
        else {
            System.out.println("false");
        }
    }

}