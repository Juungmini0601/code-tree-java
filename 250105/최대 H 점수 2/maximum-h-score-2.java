import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int l;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        // n l 입력
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        // 배열 입력
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        // 배열 원소 입력
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int h = 100; h >= 0; h--) {
            if(hCondition(h)) {
                System.out.println(h);
                return;
            }
        }
    }

    public static boolean hCondition(int h) {
        int cnt = 0;
        int curL = l;

        for(int i = 0; i < n; i++) {
            if(arr[i] >= h) {
                cnt++;
            }
            else if(curL > 0 && arr[i] + 1 >= h) {
                cnt++;
                curL--;
            }
        }

        return cnt >= h;
    }
}