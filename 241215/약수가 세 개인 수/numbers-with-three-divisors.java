import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int start;
    public static int end;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for(int i = start; i <= end; i++) {
           if(check(i)) {
             cnt++;
           }
        }
        
        sb.append(cnt);
        System.out.println(sb);
    }

    public static boolean check(int x) {
        int cnt = 0;
        
        for(int i = 1; i <= x; i++) {
            if(x % i == 0) {
                cnt++;
            }
        }

        return cnt == 3;
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
}