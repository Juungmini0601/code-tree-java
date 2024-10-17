import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(change(n));
    }

    public static int change(int n) {
        if(n == 1) {
            return 0;
        }

        if(n % 2 == 0) {
            return 1 + change(n / 2);
        } else {
            return 1 + change(n / 3);
        }
    }
}