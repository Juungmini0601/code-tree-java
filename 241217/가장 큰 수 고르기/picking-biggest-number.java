import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        input();
        int max = arr[0];

        for(int i = 1; i < 10; i++) {
            max = Math.max(arr[i], max);
        }

        System.out.println(max);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}