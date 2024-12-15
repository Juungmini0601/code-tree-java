import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int sum = 0;

        for(int i = 0; i < 10; i++) {
            if(arr[i] == 0) {
                break;
            }

            sum += arr[i];
            cnt++;
        }

        double avg = (double) sum / cnt;
        sb.append(String.format("%d %.1f", sum, avg));
        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}