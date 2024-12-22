import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        char[] arr = str.toCharArray();

        arr[1] = 'a';
        arr[arr.length-2] = 'a';

        System.out.println(String.valueOf(arr));
    }
}