import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }    

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i <= 100-17; i++) {
            int cost = 0;

            for(int j = 0; j < n; j++) {
    
                if(arr[j] < i) {
                    int diff = Math.abs(arr[j] - i);
                    cost += diff * diff;
                } 
                if(arr[j] > i + 17) {
                    int diff = Math.abs(arr[j] - i - 17);
                    cost += diff * diff;
                }
            }

            ans = Math.min(cost, ans);
        }

        System.out.println(ans);
    }
}