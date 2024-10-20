import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        int arrSum = 0;

        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
            arrSum += arr[i];
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                int sum = arrSum - arr[i] - arr[j];
                ans = Math.min(ans, Math.abs(s - sum));
            }
        }

        System.out.println(ans);
    }
}