import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static double[] arr = new double[8];

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        double sum = 0;

        for(int i = 0; i < 8; i++) {
            sum += arr[i];
        }

        double avg = sum / 8;
        sb.append(String.format("%.1f", avg));
        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 8; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
    }
}