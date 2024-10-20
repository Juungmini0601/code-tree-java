import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] arr = new char[10001];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            arr[pos] = c;
        }
        
        for(int i = 1; i <= 10000 - k; i++) {
            int sum = 0;
            for(int j = 0; j <= k; j++) {
                if(arr[i + j] == 'G') {
                    sum += 1;
                } else if(arr[i + j] == 'H'){
                    sum += 2;
                }
            }
            // System.out.println(String.format("[%d %d] = %d", i, i + k, sum));
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}