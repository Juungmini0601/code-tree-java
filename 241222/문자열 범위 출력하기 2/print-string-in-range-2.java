import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        if(str.length() < n) {
            for(int i = str.length() - 1; i >= 0; i--) {
                System.out.print(str.charAt(i));
            }
        }
        else {
            int end = str.length() - n;
            for(int i = str.length() - 1; i >= end; i--) {
                System.out.print(str.charAt(i));
            }
        }
    }
}