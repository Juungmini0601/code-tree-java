import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        
        int ans = -1;

        for(int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            int start = Math.max(0, i - k);
            int end = Math.min(n-1, i + k);

            for(int j = start; j <= end; j++) {
                if(i == j) {
                    continue;
                }

                if(bombs[i] == bombs[j]) {
                    ans = Math.max(ans, bombs[i]);
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}