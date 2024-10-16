import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;

        for(int i = a; i <= b; i++) {
            if(checkNumber(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean checkNumber(int number) {
        if(number % 2 == 0) {
            return false;
        }

        if(number % 10 == 5) {
            return false;
        }

        if(number % 3 == 0 && number % 9 != 0) {
            return false;
        }

        return true;
    }
}