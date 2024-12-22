import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] strs = {"apple", "banana", "grape", "blueberry", "orange"};
        char c = sc.next().charAt(0);

        int cnt = 0;

        for(String str: strs) {
            if(c == str.charAt(2) || c == str.charAt(3)) {
                cnt++;
                System.out.println(str);
            }
        }

        System.out.println(cnt);
    }
}