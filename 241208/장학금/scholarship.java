import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int score1 = Integer.parseInt(st.nextToken());
        int score2 = Integer.parseInt(st.nextToken());
        
        if (score1 >= 90) {
            if(score2 >= 95) {
                System.out.println(100000);
            }
            else if(score2 >= 90) {
                System.out.println(50000);
            }
            else {
                System.out.println(0);
            }
        } 
        else {
            System.out.println(0);
        }
    }
}