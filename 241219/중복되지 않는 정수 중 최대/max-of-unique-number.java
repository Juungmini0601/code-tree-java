import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr;
    public static int[] count = new int[1001];

    public static void main(String[] args) throws Exception {
        input();
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            int num = arr[i];

            if(count[num] >= 2) continue;

            max = Math.max(max, num);
        }

        System.out.printf("%d", max);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]]++;
        }
    }
}