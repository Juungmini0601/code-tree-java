import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int m;
    public static int[] arr;
    public static int[] selected;
    public static boolean[] visited;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        selected = new int[m-1];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        select(0);
        System.out.println(ans);
    }

    public static void select(int cur) {
        if(cur >= m - 1) {
            int startIndex = 0;
            int maxSum = Integer.MIN_VALUE;

            for(int i = 0; i < selected.length; i++) {
                int endIndex = selected[i];
                maxSum = Math.max(maxSum, getSum(startIndex, endIndex));
                startIndex = endIndex + 1;
            }

            maxSum = Math.max(maxSum, getSum(startIndex, n-1));

            ans = Math.min(ans, maxSum);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            if(cur != 0 && selected[cur-1] > i) continue;
            visited[i] = true;
            selected[cur] = i;
            select(cur + 1);
            selected[cur] = 0;
            visited[i] = false;
        }
    }

    public static int getSum(int startIndex, int endIndex) {
        int sum = 0;
        for(int i = startIndex; i <= endIndex; i++) {
            sum += arr[i];
        }
        return sum;
    }
}