import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        print2(n);
        System.out.println();
        print1(n);
    }

    public static void print1(int i) {
        if(i < 1) {
            return;
        }

        System.out.print(i + " ");
        print1(i - 1);
    }

    public static void print2(int i) {
        if(i < 1) {
            return;
        }

        print2(i - 1);
        System.out.print(i + " ");
    }
}
