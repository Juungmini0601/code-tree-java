import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            max = Math.max(max, h[i]);
        }

        int ans = 0;
        for(int water = 0; water <= max; water++) {
            int cnt = 0;
            for(int i = 1; i < n; i++) {
                if(h[i-1] > water && h[i] <= water) {
                    cnt++;
                }
            }
            // System.out.println(String.format("물높이: %d 빙산 개수: %d", water, cnt));
            if(h[n-1] > water) {
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}