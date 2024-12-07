import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        double eye = Double.parseDouble(st.nextToken());
        
        if (eye >= 1.0) {
            System.out.println("High");
        } 
        else if(eye >= 0.5) {
            System.out.println("Middle");
        }
        else {
            System.out.println("Low");
        }
    }
}