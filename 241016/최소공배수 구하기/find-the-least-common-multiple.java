import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        printAnswer(n, m);
    }

    public static int getGCD(int a, int b) {
        int minNumber = a > b ? b : a;
        int ret = 1;
        for (int i = 1; i <= minNumber; i++) {
            if(a % i == 0 && b % i == 0) {
                ret = i;
            }
        }

        return ret;
    }

    public static void printAnswer(int a, int b) {
        int answer = a * b / getGCD(a, b);
        System.out.println(answer);
    }
}