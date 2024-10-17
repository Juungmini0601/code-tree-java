import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getSum(n));
    }

    public static int getSum(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int x = n % 10;
        return x * x + getSum(n / 10);
    }
}