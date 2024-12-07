import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int score = Integer.parseInt(st.nextToken());
        
        if (score >= 80) {
            System.out.println("pass");
        }
        else {
            System.out.printf("%d more score\n", (80 - score));
        }
    }
}