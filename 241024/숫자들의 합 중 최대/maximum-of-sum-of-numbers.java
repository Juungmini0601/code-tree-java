import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int ans = 0;

        for(int i = x; i <= y; i++) {
            ans = Math.max(ans, calcSum(i));
        }

        System.out.println(ans);
    }

    public static int calcSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}