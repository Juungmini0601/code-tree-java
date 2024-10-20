import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[401];

        for(int i = 0; i < n; i++) {
            int amount = sc.nextInt();
            int idx = sc.nextInt();
            arr[idx] += amount;
        }
        int max = 0;

        for(int i = 0; i <= 100; i++) {
            int start = i - k < 0 ? 0 : i -k;
            int end = i + k > 100 ? 100 : i + k;

            int sum = 0;

            for(int j = start; j <= end; j++) {
                sum += arr[j];
            }

            max = Math.max(max, sum);
            // System.out.println(String.format("[%d %d] = %d", start, end ,sum ));
        }

        System.out.println(max);
    }
}