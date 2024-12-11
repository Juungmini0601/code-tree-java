import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int sum = 0;
        int cnt = 0;

        for(int i = a ; i <= b; i++) {
            if(i % 5 == 0 || i % 7 == 0) {
                sum += i;
                cnt++;
            }
        }

        double avg = (double) sum / cnt;
        System.out.printf("%d %.1f\n", sum, avg);
    }

}