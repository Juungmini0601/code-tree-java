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
        int min = arr[0];
        
        for(int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
        }

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == min) {
                cnt++;
            }
        }

        System.out.printf("%d %d", min, cnt);
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