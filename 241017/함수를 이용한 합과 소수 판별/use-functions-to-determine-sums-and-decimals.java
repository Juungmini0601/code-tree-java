import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;

        for(int i = a; i <= b; i++) {
            if(isPrime(i) && getSum(i) % 2 == 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean isPrime(int number) {
        if(number == 1) return false;

        for(int i = 2; i < number; i++) {
            if(number % i == 0) return false;
        }

        return true;
    }

    public static int getSum(int number) {
        int ret = 0;

        while(number > 0) {
            ret += number % 10;
            number /= 10;
        }

        return ret;
    }
}