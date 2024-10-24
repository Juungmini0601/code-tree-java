import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = 0;

        for(int i = x; i <= y; i++) {
            if(check(i + "")) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean check(String num) {
        int n = num.length() / 2;
        
        for(int i = 0, j = num.length() - 1; i <= n; i++, j--) {
            if(num.charAt(i) != num.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}