import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr = new int[101];
    public static int[][] lines;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        lines = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines[i] = new int[]{start, end};
        }

        for(int e = 0 ; e < n; e++) {
            for(int i = 1; i <= 100; i++) {
                if(check(i, e)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    public static boolean check(int x, int exclude) {
        for(int i = 0; i < n; i++) {
            if(i == exclude) continue;
            
            int start = lines[i][0];
            int end = lines[i][1];

            if(x < start || x > end) return false;
        }
        
        return true;
    }
}