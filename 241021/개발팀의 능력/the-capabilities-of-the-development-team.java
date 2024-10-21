import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[5];
        int total = 0;

        for(int i = 0; i < 5; i++) {
            scores[i] = sc.nextInt();
            total += scores[i];
        }
        
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++) {
            for(int j = i+1; j < 5; j++) {
                for(int k = 0; k < 4; k++) {
                    for(int l = k+1; l < 5; l++) {
                        if(l == j || l == i || k == i || k == j) {
                            continue;
                        }

                        int sum1 = scores[i] + scores[j];
                        int sum2 = scores[k] + scores[l];
                        int sum3 = total - sum1 - sum2;

                        if(sum1 == sum2 || sum2 == sum3 || sum1 == sum3) {
                            continue;
                        }

                        int maxValue = max(sum1, sum2, sum3);
                        int minValue = min(sum1, sum2, sum3);
                        ans = Math.min(ans, maxValue - minValue);
                    }
                }
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
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