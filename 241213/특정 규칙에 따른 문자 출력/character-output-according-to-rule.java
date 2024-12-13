import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n; 

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    public static void solution() {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            // 공백 출력
            for(int j = 1; j <= n-i; j++) {
                sb.append("  ");
            }
            
            // 별 출력
            for(int j = 1; j <= i; j++) {
                sb.append("@ ");
            }
            
            sb.append("\n");
        }

        for(int i = n-1; i >= 1; i--) {
            // 별 출력
            for(int j = 1; j <= i; j++) {
                sb.append("@ ");
            }
            
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }

}