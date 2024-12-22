import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String[] strs = new String[10];
        for(int i = 0; i < 10; i++) {
            strs[i] = br.readLine();
        }

        char c = br.readLine().charAt(0);
        boolean no = true;

        for(int i = 0; i < 10; i++) {
            if(strs[i].charAt(strs[i].length()-1) == c) {
                System.out.println(strs[i]);
                no = false;
            }
        }

        if(no) {
            System.out.println("None");
        }
    }
}