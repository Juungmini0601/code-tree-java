import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] arr = new int[2][4];

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();

        // 가로 평균
        for(int i = 0; i < 2; i++) {
            int sum = 0;

            for(int j = 0; j < 4; j++) {
                sum += arr[i][j];
            }

            double avg = (double) sum / 4;

            sb.append(String.format("%.1f", avg)).append(" ");
        }
        
        sb.append("\n");

        // 세로 평균
        for(int i = 0; i < 4; i++) {
            int sum = 0;

            for(int j = 0; j < 2; j++) {
                sum += arr[j][i];
            }

            double avg = (double) sum / 2;
            sb.append(String.format("%.1f", avg)).append(" ");
        }

        sb.append("\n");

        int sum = 0;
        for(int i = 0; i < 2; i++) {
            
            for(int j = 0; j < 4; j++) {
                sum += arr[i][j];
            }

        }

        double avg = (double) sum / 8;
        sb.append(String.format("%.1f", avg)).append("\n");
        System.out.println(sb);
    }

    public static void input() throws Exception {
        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}