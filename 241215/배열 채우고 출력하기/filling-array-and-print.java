import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static char[] arr = new char[10];

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();

        for(int i = 9; i >= 0; i--) {
            sb.append(arr[i]);
        }
        
        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < 10; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
    }
}