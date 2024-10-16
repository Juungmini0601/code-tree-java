import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int o = sc.next().charAt(0);
        int c = sc.nextInt();

        if(o == '+') {
            System.out.printf("%d + %d = %d%n", a, c, add(a, c));
        } else if(o == '-') {
            System.out.printf("%d - %d = %d%n", a, c, minus(a, c));
        } else if(o == '/') {
            System.out.printf("%d / %d = %d%n", a, c, divide(a, c));
        } else if(o == '*') {
            System.out.printf("%d * %d = %d%n", a, c, multi(a, c));
        } else {
            System.out.println("False");
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static int multi(int a, int b) {
        return a * b;
    }
}