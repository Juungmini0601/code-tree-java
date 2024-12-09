import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        String answer = (a / b) + ".";
        a %= b;
        a *= 10;

        for(int i = 0; i < 20; i++) {
            answer += a / b;
            a %= b;
            a *= 10;
        }

        System.out.println(answer);
    }
}