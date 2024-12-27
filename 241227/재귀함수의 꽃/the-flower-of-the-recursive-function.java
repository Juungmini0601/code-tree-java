import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        print(n);
    }

    public static void print(int num) {
        if(num <= 0) {
            return;
        }

        System.out.print(num + " ");
        print(num-1);
        System.out.print(num + " ");
    }
}
