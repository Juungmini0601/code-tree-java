import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        printStar(n);
    }

    public static void printStar(int num) {
        if(num <= 0) {
            return;
        }

        for(int i = 0; i < num; i++) {
            System.out.print("* ");
        }
        System.out.println();
        printStar(num-1);
        for(int i = 0; i < num; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
