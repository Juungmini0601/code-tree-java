import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        String q = br.readLine();

        for(int i = 0; i < q.length(); i++) {
            char command = q.charAt(i);

            if(command == 'L') {
                str = str.substring(1) + str.substring(0, 1);
            }
            else if (command == 'R') {
                str = str.substring(str.length()-1) + str.substring(0, str.length() - 1);
            }
        }

        System.out.println(str);
    }
}
