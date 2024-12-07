import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int gender = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int age = Integer.parseInt(st.nextToken());

        if(gender == 0) {
            if(age >= 19) {
                System.out.println("MAN");
            } 
            else {
                System.out.println("BOY");
            }
        }
        else {
            if(age >= 19) {
                System.out.println("WOMAN");
            }
            else {
                System.out.println("GIRL");
            }
        }
    }

}