import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int k;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        // n, k 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        // arr 입력
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= 100; i++) {
            if(condition(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    public static boolean condition(int maxValue) {
        int[] selected = new int[n];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= maxValue) {
                selected[cnt] = i;
                cnt++;
            }   
        }

        if(arr[cnt-1] != n - 1) {
            return false;
        }

        for(int i = 1; i < cnt; i++) {
            if(selected[i] - selected[i-1] > k) {
                return false;
            }
        }

        return true;
    }
}