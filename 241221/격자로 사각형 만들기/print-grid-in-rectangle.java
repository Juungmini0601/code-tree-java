import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringBuilder sb = new StringBuilder();

        for(int col = 0; col < n; col++) arr[0][col] = 1;
        for(int row = 0; row < n; row++) arr[row][0] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1] + arr[i-1][j-1];
                
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}