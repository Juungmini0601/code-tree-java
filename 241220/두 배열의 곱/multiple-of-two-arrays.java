import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] arr1 = new int[3][3];
    public static int[][] arr2 = new int[3][3];

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                sb.append(arr1[i][j] * arr2[i][j]).append(" ");
            }
            
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {        
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.readLine();

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}