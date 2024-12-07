import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int aMath = Integer.parseInt(st.nextToken());
        int aEng = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int bMath = Integer.parseInt(st.nextToken());
        int bEng = Integer.parseInt(st.nextToken());
        
        if (aMath != bMath) {
            if(aMath > bMath) {
                System.out.println("A");
            } 
            else {
                System.out.println("B");
            }
        }
        else {
            if(aEng > bEng) {
                System.out.println("A");
            }
            else {
                System.out.println("B");
            }
        }
    }
}