import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        if (n == 1) {
            System.out.println("John");
        } 
        else if(n == 2) {
            System.out.println("Tom");
        }
        else if(n == 3){
            System.out.println("Paul");
        }
        else {
            System.out.println("Vacancy");
        }
    }
}