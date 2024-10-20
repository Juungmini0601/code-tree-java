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
        // i로 모일때의 합을 구함
        // j는 옮길 친구
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                if(j < i) {
                    sum += (j - i + arr.length) * arr[j];
                } else {
                    sum += (j - i) * arr[j];
                }
            }

            ans = Math.min(ans, sum);
        }

        System.out.println(ans);
    }
}