import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int water = Integer.parseInt(st.nextToken());
        
        if (water < 0) {
            System.out.println("ice");
        } 
        else if(water < 100) {
            System.out.println("water");
        }
        else {
            System.out.println("vapor");
        }
    }
}