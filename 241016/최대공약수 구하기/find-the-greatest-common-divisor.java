import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        print(n, m);
    }

    public static void print(int a, int b) {
        int ret = 1;
        int minNumber = a > b ? b : a;

        for(int i = 1; i <= minNumber; i++) {
            if(a % i == 0 && b % i == 0) {
                ret = i;
            }
        }

        System.out.println(ret);
    }
}