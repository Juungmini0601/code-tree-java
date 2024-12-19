import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] arr = new int[4][4];

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 4; i++) {
            int sum = 0;
            
            for(int j = 0; j < 4; j++) {
                sum += arr[i][j];
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}