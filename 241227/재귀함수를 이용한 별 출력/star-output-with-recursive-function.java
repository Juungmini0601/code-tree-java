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

    public static void printStar(int i) {
        if(i <= 0) {
            return;
        }

        printStar(i-1);
        for(int j = 0; j < i; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
