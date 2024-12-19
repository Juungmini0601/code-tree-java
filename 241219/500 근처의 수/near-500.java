import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        input();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < 10; i++) {
            if(arr[i] > 500) {
                min = Math.min(arr[i], min);
            } else {
                max = Math.max(arr[i], max);
            }
        }

        System.out.printf("%d %d", max, min);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
    
        for(int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}