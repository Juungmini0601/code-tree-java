import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static char[][] arr = new char[5][3];

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; i++) {
            
            for(int j = 0; j < 3; j++) {
                arr[i][j] = (char) (arr[i][j] - 32);
                sb.append(arr[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }
    }
}