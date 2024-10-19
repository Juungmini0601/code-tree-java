import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int ans = getTotalMiniut(a - 11, b, c) - getTotalMiniut(0, 11, 11);
        System.out.println(ans >= 0 ? ans : -1);
    }

    public static int getTotalMiniut(int d, int h, int m) {
        return d * 24 * 60 + h * 60 + m;
    }
}