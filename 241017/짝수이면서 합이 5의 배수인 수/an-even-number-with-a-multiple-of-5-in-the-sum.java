import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n % 2 == 0 && getSum(n) % 5 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static int getSum(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}