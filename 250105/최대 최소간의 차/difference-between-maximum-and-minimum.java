import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int k;
    public static int[] arr;
    public static final int MAX_NUMBER = 10000;


    public static void main(String[] args) throws Exception {
        // n k 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        // 배열 입력
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = Integer.MAX_VALUE;

        for(int num = 1; num <= MAX_NUMBER; num++) {
            int minValue = num;
            int maxValue = num + k;
            // 최대 최소의 범위가 주어진 수의 범위를 넘어가면 카운트 할 필요가 없다?
            // k = 5000이야 최대 최소간의 차이가 5000이하이기만 하면 됨.
            if(maxValue > MAX_NUMBER) continue;

            int cost = 0;

            for(int i = 0; i < n; i++) {
                int elem = arr[i];

                if(arr[i] >= minValue && arr[i] <= maxValue) continue;

                if(arr[i] < minValue) {
                    cost += minValue - arr[i];
                } else if(arr[i] > maxValue) {
                    cost += arr[i] - maxValue;
                }
            }

            ans = Math.min(ans, cost);
        }

        System.out.println(ans);
    }
}