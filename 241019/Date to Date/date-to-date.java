import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int ans = getTotalDay(m2, d2) - getTotalDay(m1, d1) + 1;
        System.out.println(ans);
    }

    public static int getTotalDay(int m, int d) {
        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = 0;

        for(int x = 1; x < m; x++) {
            ans += num_of_days[x];
        }

        return ans + d;
    }
}