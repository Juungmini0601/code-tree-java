import java.util.Scanner;

public class Main {

    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 10;

    public static int n;
    public static int[] num = new int[MAX_N];

    public static int ans = INT_MAX;

    public static Scanner sc = new Scanner(System.in);

    public static void findMin(int idx, int cnt) {
        if (idx >= n - 1) {
            ans = Math.min(ans, cnt);
            return;
        }

        for(int dist = 1; dist <= num[idx]; dist++) {
            findMin(idx + dist, cnt + 1);
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        
        findMin(0, 0);
        
        if(ans == INT_MAX) {
            ans = -1;
        }

        System.out.println(ans);
    }
}