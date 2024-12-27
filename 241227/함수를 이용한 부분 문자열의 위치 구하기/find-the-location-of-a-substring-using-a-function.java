import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(indexOf(str1, str2));
    }

    public static int indexOf(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for(int i = 0; i < n - m + 1; i++) {
            if(str1.substring(i, i + m).equals(str2)) {
                return i;
            }
        }

        return -1;
    }
}
