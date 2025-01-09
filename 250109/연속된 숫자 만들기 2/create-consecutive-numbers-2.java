import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] arr = new int[3];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        if(Math.abs(arr[0] - arr[1]) == 1 && Math.abs(arr[2] - arr[1]) == 1) {
            ans = 0;
        }
        // Case1 2명의 사람만 연속인 경우
        else if(Math.abs(arr[0] - arr[1]) == 1 || Math.abs(arr[2] - arr[1]) == 1 || Math.abs(arr[2] - arr[0]) == 1) {
            ans = 1;
        }
        // Case2 3명의 사람이 연속이 아닌 경우
        else {
            if(Math.abs(arr[0] - arr[1]) == 2 || Math.abs(arr[2] - arr[1]) == 2) {
                ans = 1;
            } 
            else {
                ans = 2;
            }
        }

        System.out.println(ans);
    }
}