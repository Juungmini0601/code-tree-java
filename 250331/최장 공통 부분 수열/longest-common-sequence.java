import java.util.Scanner;

public class Main {
    public static final int MAX_LEN = 1000;

    public static String str1, str2;
    public static int [][]dp = new int[MAX_LEN + 1][MAX_LEN + 1];

    public static int str1Len, str2Len;

    public static void initialize() {
        
        dp[1][1] = str1.charAt(1) == str2.charAt(1) ? 1 : 0;

     
        for(int i = 2; i <= str1Len; i++){
            if(str1.charAt(i) == str2.charAt(1))
                dp[i][1] = 1;
            else
                dp[i][1] = dp[i-1][1];
        }
        
        for(int j = 2; j <= str2Len; j++){
            if(str1.charAt(1) == str2.charAt(j))
                dp[1][j] = 1;
            else
                dp[1][j] = dp[1][j-1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        str1 = sc.next();
        str2 = sc.next();

        str1Len = str1.length();
        str2Len = str2.length(); 

        str1 = "#" + str1;
        str2 = "#" + str2;

        initialize();

        for(int i = 2; i <= str1Len; i++){
           
            for(int j = 2; j <= str2Len; j++){
                
                if(str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[str1Len][str2Len]);
    }
}
