import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        for(int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(b);
        int cnt = 0;

        for(int i = 0; i <= n - m; i++) {
            int[] temp = new int[m];
            for(int j = 0; j < m; j++) {
                temp[j] = a[i+j];
            }
            Arrays.sort(temp);
            
            if(equal(b, temp)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean equal(int[] a, int[] b) {
        int len = a.length;
        
        for(int i = 0; i < len; i++) {
            if(a[i] != b[i]) return false;
        }

        return true;
    }
}