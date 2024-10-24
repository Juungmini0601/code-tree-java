import java.util.Scanner;

public class Main {

    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int max = 0;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        select(0);
        System.out.println(max);
    }

    public static void select(int num) {
        if(num > c) {
            return;
        }

        max = Math.max(max, num);

        select(num + a);
        select(num + b);
    }
}