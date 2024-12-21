import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    public static int n;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        StringBuilder sb = new StringBuilder();

        for(int row = 1; row <= n; row++) {
            arr[row][1] = 1;
            arr[row][row] = 1;
        }

        for(int row = 2; row <= n; row++) {
            for(int col = 2; col <= row; col++) {
                arr[row][col] = arr[row-1][col-1] + arr[row-1][col];
            }
        }

        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= row; col++) {
                sb.append(arr[row][col]).append(" ");
            }
            
            sb.append("\n");
        }

        System.out.println(sb);
    }
}