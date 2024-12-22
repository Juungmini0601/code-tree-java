import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String a = br.readLine();
        String b = br.readLine();

        String ab = a + b;
        String ba = b + a;

        if(ab.equals(ba)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}