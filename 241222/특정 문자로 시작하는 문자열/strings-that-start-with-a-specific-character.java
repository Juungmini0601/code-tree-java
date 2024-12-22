import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        
        for(int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }

        char c = br.readLine().charAt(0);
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(strs[i].charAt(0) == c) {
                sum += strs[i].length();
                cnt++;
            }
        }

        double avg = (double) sum / cnt;

        System.out.printf("%d %.2f", cnt, avg);
    }
}