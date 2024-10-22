import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] prices = new int[n];

        for(int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            int[] arr = new int[n];

            for(int j = 0; j < n; j++) {
                int p = prices[j];
                
                if(j == i) {
                    p /= 2;
                }

                arr[j] = p;
            }

            Arrays.sort(arr);

            int temp = 0;
            int sum = 0;
            int cnt = 0;

            for(int j = 0; j < n; j++) {
                int nextSum = sum + arr[j];
                
                if(nextSum > b) {
                    break;
                }

                sum = nextSum;
                cnt++;
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}