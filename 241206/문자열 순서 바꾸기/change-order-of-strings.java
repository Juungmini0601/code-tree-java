import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String s1 = br.readLine();
        String s2 = br.readLine();
        
        String temp = s1;
        s1 = s2;
        s2 = temp;

        System.out.println(s1);
        System.out.println(s2);
    }
}