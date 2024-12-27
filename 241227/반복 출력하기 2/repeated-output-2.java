import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        print(0);    
    }

    public static void print(int i) {
        if(i >= n) {
            return;
        }

        System.out.println("HelloWorld");
        print(i + 1);
    }
}
