import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 200;
    public static final int MAX_M = 200;

    public static int n, m;

    public static int[] s = new int[MAX_N + 1];
    public static int[] e = new int[MAX_N + 1];
    public static int[] v = new int[MAX_N + 1];

    public static int[][] dp = new int[MAX_M + 1][MAX_N + 1];

    public static void initialize() {

        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                dp[i][j] = INT_MIN;
        
        for(int j = 1; j <= n; j++)
            if(s[j] == 1)
                dp[1][j] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int j = 1; j <= n; j++) {
            s[j] = sc.nextInt();
            e[j] = sc.nextInt();
            v[j] = sc.nextInt();
        }

        initialize();

        for(int i = 2; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(s[k] <= i - 1 && i - 1 <= e[k] && s[j] <= i && i <= e[j])
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(v[j] - v[k]));
                }
            }
        }

    
        int ans = 0;
        for(int j = 1; j <= n; j++)
            ans = Math.max(ans, dp[m][j]);

        System.out.println(ans);
    }
}
