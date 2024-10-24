import java.util.Scanner;

public class Main {

    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int max = 0;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        
        for(int i = 0; i <= 1000; i++) {
            if(i * a > c) {
                break;
            }

            int temp = (c - a * i) / b * b;
            max = Math.max(a * i + temp, max);
        }

        System.out.println(max);
    }

   
}