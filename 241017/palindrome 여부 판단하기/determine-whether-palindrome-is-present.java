import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(palindrome(input) ? "Yes" : "No");
    }

    public static boolean palindrome(String word) {
        for(int i = 0, j = word.length() - 1; i < word.length() / 2; i++, j--) {
            if(word.charAt(i) != word.charAt(j)) return false;
        }
        return true;
    }
}