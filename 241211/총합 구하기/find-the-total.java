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
    
        for(int i = a ; i <= b; i++) {
            if(i % 6 == 0 && i % 8 != 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

}