import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        boolean ans = !singleChar(str);
        System.out.println(ans ? "Yes" : "No");
    }

    // 하나의 문자열로 이루어져 있으면 true를 반환
    public static boolean singleChar(String str) {
        char c = str.charAt(0);

        for(int i = 1; i < str.length(); i++) {
            if(c != str.charAt(i)) return false;
        }

        return true;
    }
}
