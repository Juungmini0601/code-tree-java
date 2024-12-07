import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        char c = st.nextToken().charAt(0);
        
        if (c == 'S') {
            System.out.println("Superior");
        } 
        else if(c == 'A') {
            System.out.println("Excellent");
        }
        else if(c == 'B'){
            System.out.println("Good");
        }
        else if(c == 'C') {
            System.out.println("Usually");
        }
        else if(c == 'D') {
            System.out.println("Effort");
        }
        else {
            System.out.println("Failure");
        }
    }
}