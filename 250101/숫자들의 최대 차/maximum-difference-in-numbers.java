import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int k;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        // n k 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        // 배열 입력
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 정렬
        Arrays.sort(arr);
        int answer = 0;
        // 최대 최소 계산
        for(int i = 0; i < n; i++) {
            int diff = arr[i] - arr[0];
            // 차이가 k보다 크다면 앞으로 계속 커지므로 멈춘다.
            if(diff > k) {
                break;
            }
            answer = i + 1;
        }

        System.out.println(answer);
    }
}