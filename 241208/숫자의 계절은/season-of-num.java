import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        
        if(month == 12 || month <= 2) {
            System.out.println("Winter");
        }
        else if(month <= 5) {
            System.out.println("Spring");
        }
        else if(month <= 8) {
            System.out.println("Summer");
        }
        else if(month <= 11) {
            System.out.println("Fall");
        }
    }
}