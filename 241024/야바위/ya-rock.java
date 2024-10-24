import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] inputs = new int[n][3];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++){
                inputs[i][j] = sc.nextInt();
            }
        }

        int ans = 0;

        for(int i = 1; i <= 3; i++) {
            int cnt = 0;
            boolean[] stones = new boolean[4];
            stones[i] = true;

            for(int j = 0; j < n; j++) {    
                int a = inputs[j][0];
                int b = inputs[j][1];
                int c = inputs[j][2];
                
                // System.out.println("교환전: " + Arrays.toString(stones));
                boolean temp = stones[a];
                stones[a] = stones[b];
                stones[b] = temp;
                // System.out.println("교환후: " + Arrays.toString(stones));

                if(stones[c]) {
                    cnt++;
                }
            }
            // System.out.println(String.format("%d번째 돌 선택: %d", i, cnt));
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}