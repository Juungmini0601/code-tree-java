import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int sum = 0;
        int cnt = 0;
        double avg = 0;

        for(int i = 1 ; i <= 10; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if(num >= 0 && num <= 200) {
                sum += num;
                cnt++;
            }
        }

        avg = (double) sum / cnt;

        System.out.printf("%d %.1f\n", sum, avg);
    }

}