import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        String target = br.readLine();
        System.out.println(count(str, target));
    }

    public static int count(String str, String target) {
        int cnt = 0;
        for(int i = 0; i < str.length() - target.length() + 1; i++) {
            if(str.substring(i, i + target.length()).equals(target)) {
                cnt++;
            }
        }

        return cnt;
    }
}