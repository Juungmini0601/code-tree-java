import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        int maxDiff = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int dif = arr[j] - arr[i];
                if(dif >= 0) {
                    maxDiff = Math.max(dif, maxDiff);
                }
            }
        }

        System.out.println(maxDiff);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}