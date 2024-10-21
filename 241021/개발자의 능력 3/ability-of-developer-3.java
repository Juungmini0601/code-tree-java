import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[6];
        int total = 0;

        for(int i = 0; i < 6; i++) {
            scores[i] = sc.nextInt();
            total += scores[i];
        }
        
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++) {
            for(int j = i + 1; j < 5; j++) {
                for(int k = j + 1; k < 6; k++) {
                    int sum1 = scores[i] + scores[j] + scores[k];
                    int sum2 = Math.abs(total - sum1);
                    // System.out.println(String.format("[%d %d %d] = %d %d", scores[i], scores[j], scores[k], sum, Math.abs(total - sum)));
                    ans = Math.min(ans, Math.abs(sum1 - sum2));
                }
            }
        }

        System.out.println(ans);
    }
}