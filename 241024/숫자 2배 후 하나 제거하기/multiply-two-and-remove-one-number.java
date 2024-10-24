import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            arr[i] *=2;
            
            // j번째 숫자 제거
            for(int j = 0; j < n; j++) {
                int[] remains = new int[n-1];
                int cnt = 0;
                for(int k = 0; k < n; k++) {
                    if(j == k) {
                        continue;
                    }
                    remains[cnt++] = arr[k];
                }

                int sum = 0;
                for(int k = 1; k < remains.length; k++) {
                    sum += Math.abs(remains[k] - remains[k-1]);
                }
                ans = Math.min(ans, sum);
            }

            arr[i] /=2;
        }

        System.out.println(ans);
    }
}