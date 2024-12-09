import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {        
        int n = Integer.parseInt(br.readLine());
        int i = n;

        while(i >= 1) {
            System.out.print(i + " ");
            i--;
        }
    }
}