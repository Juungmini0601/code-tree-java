import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int ans = 0;

        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i <= n - k; i++) {
            int tempSum = 0;
    
            for(int j = i; j < i + k; j++) {
                tempSum += arr[j];
            }

            ans = Math.max(ans, tempSum);
        }

        System.out.println(ans);
    }
}