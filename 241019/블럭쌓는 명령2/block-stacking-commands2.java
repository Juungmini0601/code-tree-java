import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i = 0; i < k; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for(int j = start; j <= end; j++) {
                arr[j]++;
            }
        }

        int ans = arr[1];
        for(int i = 2; i < arr.length; i++) {
            ans = Math.max(ans, arr[i]);
        }

        System.out.println(ans);
    }
}