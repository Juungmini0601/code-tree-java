import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
    
    public static int solve(int num) {
        if(num == 1) {
            return 0;
        }

        int next = num % 2 == 0 ? num / 2 : num / 3;
        return 1 + solve(next);
    }
}