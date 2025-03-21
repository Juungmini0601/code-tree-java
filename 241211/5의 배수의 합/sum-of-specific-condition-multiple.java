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
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        for(int i = min ; i <= max; i++) {
            if(i % 5 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

}