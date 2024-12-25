import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int num = Integer.parseInt(br.readLine());

        if(num % 2 == 0 && sum(num) % 5 == 0) {
            System.out.println("Yes");
        } 
        else {
            System.out.println("No");
        }
    }

    public static int sum(int num) {
        String str = "" + num;
        int ret = 0;

        for(char c: str.toCharArray()) {
            ret += c - '0';
        }

        return ret;
    }
}
