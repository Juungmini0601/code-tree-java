import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] sums = new int[n-1];

        for(int i = 0; i < n - 1; i++) {
            sums[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 원소는 첫번째 합 보다 작은 수이다.
        for(int i = 1; i < sums[0]; i++) {
            // 사용될 숫자를 셀 배열
            int[] nums = new int[1001];
            // 사용할 배열
            int[] selected = new int[n];
            // 첫 원소에 i를 넣어주면 다음 값은 무조건 결정된다.
            selected[0] = i;
            nums[i]++;

            boolean flag = false;

            for(int j = 1; j < n; j++) {
                int num = sums[j-1] - selected[j-1];
                
                if(num <= 0 || nums[num] >= 1) {
                    flag = true;
                    break;
                }

                nums[num]++;
                selected[j] = num;
            }

            if(!flag) {
                for(int j = 0; j < n; j++) {
                    System.out.print(selected[j] + " ");
                }
                return;
            }
        }
    }
}