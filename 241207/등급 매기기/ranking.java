import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int score = Integer.parseInt(st.nextToken());
        
        if (score >= 90) {
            System.out.println("A");
        } 
        else if(score >= 80) {
            System.out.println("B");
        }
        else if(score >= 70){
            System.out.println("C");
        }
        else if(score >= 60) {
            System.out.println("D");
        }
        else {
            System.out.println("F");
        }
    }
}