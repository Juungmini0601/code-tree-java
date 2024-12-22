import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        int aCnt = 0;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            sum += str.length();

            if(str.charAt(0) == 'a') {
                aCnt++;
            }
        }
        
        System.out.println(sum + " " + aCnt);
    }
}