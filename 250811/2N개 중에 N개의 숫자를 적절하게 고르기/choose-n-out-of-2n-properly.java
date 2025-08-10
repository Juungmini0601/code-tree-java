import java.util.Scanner;

public class Main {
    
    public static final int MAX_N = 10;

    public static int n;
    public static int[] num = new int[2 * MAX_N];
    public static boolean[] visited = new boolean[2 * MAX_N];

    public static int ans = Integer.MAX_VALUE;

    public static int calc() {
        int diff = 0;
        
        for(int i = 0; i < 2 * n; i++) {
            diff += num[i] * (visited[i] ? 1 : -1);
        }

        return Math.abs(diff);
    }

    public static void findMinDiff(int currentIndex, int count) {
        if(count == n) {
            ans = Math.min(ans, calc());
            return;
        }

        if(currentIndex >= 2 * n) {
            return;
        }

        visited[currentIndex] = true;
        findMinDiff(currentIndex + 1, count + 1);
        visited[currentIndex] = false; 

        findMinDiff(currentIndex + 1, count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < 2 * n; i++) {
            num[i] = sc.nextInt();
        }

        findMinDiff(0, 0);
        System.out.println(ans);
    }
}