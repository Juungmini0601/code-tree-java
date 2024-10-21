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
        // 98163
        // scores = new int[] {525368 ,186290 ,366998 ,362762 ,603677 ,457716 };
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < 5; i++) {
            for(int j = i+1; j < 6; j++) {
                for(int k = 0; k < 5; k++) {
                    for(int l = k+1; l < 6; l++) {
                        if(l == j || l == i || k == i || k == j) {
                            continue;
                        }

                        int sum1 = scores[i] + scores[j];
                        int sum2 = scores[k] + scores[l];
                        int sum3 = total - sum1 - sum2;
                        int maxValue = max(sum1, sum2, sum3);
                        int minValue = min(sum1, sum2, sum3);
                        ans = Math.min(ans, maxValue - minValue);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static int max(int a, int b, int c) {
        int max = a;

        if(max < b) {
            max = b;
        }

        if(max < c) {
            max = c;
        }

        return max;
    }

    public static int min(int a, int b, int c) {
        int min = a;

        if(min > b) {
            min = b;
        }

        if(min > c) {
            min = c;
        }

        return min;
    }
}