import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(check(input) ? "No" : "Yes");
    }

    public static boolean check(String input) {
        for(int i = 1; i < input.length(); i++) {
            if(input.charAt(i-1) != input.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}