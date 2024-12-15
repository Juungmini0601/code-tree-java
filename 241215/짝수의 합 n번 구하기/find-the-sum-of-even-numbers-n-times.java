import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());

           int sum = 0;

           for(int num = a; num <= b; num++) {
                if(num % 2 == 0) {
                    sum += num;
                }
           }
           sb.append(sum + "\n");
        }
        
        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }
}