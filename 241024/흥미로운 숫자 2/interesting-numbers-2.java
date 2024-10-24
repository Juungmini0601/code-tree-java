import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = 0;

        // System.out.println(check(110));
        for(int num = x; num <= y; num++) {
            // System.out.println(String.format("%d = %b", num, check(num)));
            if(check(num)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean check(int num) {
        int[] arr = new int[10];

        while(num != 0) {
            int cur = num % 10;
            arr[cur]++;
            num /= 10;
        }

        int cnt = 0;
        int number1 = -1;
        int number2 = -1;

        for(int i = 0; i < 10; i++) {
            if(arr[i] >= 1) {
                cnt++;
                if(number1 == -1) {
                    number1 = i;
                } else {
                    number2 = i;
                }
            }
        }

        if(cnt != 2) {
            return false;
        }

        return arr[number1] == 1 || arr[number2] == 1;
    }
}