import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;

        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n - 2; j++) {
                // ans = Math.max(ans, arr[i][j] + arr[i][j+1] + arr[i][j+2]);
                for(int k = i + 1; k < n; k++) {
                    for(int l = 0; l < n - 2; l++) {
                        int sum1 = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                        int sum2 = arr[k][l] + arr[k][l+1] + arr[k][l+2];
                        ans = Math.max(ans, sum1 + sum2);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}