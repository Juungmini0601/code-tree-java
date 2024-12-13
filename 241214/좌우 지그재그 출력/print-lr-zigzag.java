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
        int cnt = 1;

        for(int i = 1; i <= n; i++) {
            if(i % 2 == 1) {
                for(int j = 1; j <= n; j++) {
                    sb.append(cnt + " ");
                    if(j != n)
                        cnt++;
                }
            }
            else {
                for(int j = 1; j <= n; j++) {
                    sb.append(cnt + " ");
                    if(j!=n)
                        cnt--;
                }
            }

            cnt += n;
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }

}