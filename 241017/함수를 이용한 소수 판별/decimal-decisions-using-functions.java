import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;

        for(int i = a; i <= b; i++) {
            if(isPrime(i)) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

    public static boolean isPrime(int number) {
        if(number == 1) return false;
        
        for(int i = 2; i < number; i++) {
            if(number % i == 0) return false;
        }

        return true;
    }
}