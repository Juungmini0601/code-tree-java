import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);

        char[] arr = str.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == c1) {
                arr[i] = c2;
            }
            else if(arr[i] == c2) {
                arr[i] = c1;
            }
        }

        System.out.println(String.valueOf(arr));
    }
}