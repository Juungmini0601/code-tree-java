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

    public static void solution() {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
    }
}