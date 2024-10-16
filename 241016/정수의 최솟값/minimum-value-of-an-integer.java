import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(getMin(a, b, c));
    }

    public static int getMin(int a, int b, int c) {
        int ret = a;
        ret = Math.min(ret, b);
        ret = Math.min(ret, c);
        return ret;
    }
}