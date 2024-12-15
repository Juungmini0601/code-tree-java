import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static double[] arr;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        double sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }

        double avg = sum / n;

        sb.append(String.format("%.1f\n", avg));
        
        if(avg >= 4.0) {
            sb.append("Perfect");
        }
        else if(avg >= 3.0) {
            sb.append("Good");
        }
        else {
            sb.append("Poor");
        }
        
        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new double[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
    }
}