import java.util.Scanner;

public class Main {

    public static int answer = Integer.MAX_VALUE;
    public static char[] arr;
    public static String word;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        word = sc.nextLine();
        arr = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            word = shift();
            answer = Math.min(answer, encode(word).length());
        }

        System.out.println(answer);
    }

    public static String encode(String word) {
        int cnt = 1;
        String encoded = "";

        for(int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
                continue;
            }

            encoded += word.charAt(i - 1);
            encoded += cnt;
            cnt = 1;
        }

        encoded += word.charAt(word.length() - 1);
        encoded += cnt;

        return encoded;
    }

    public static String shift() {
        char temp = arr[arr.length - 1];

        for(int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = temp;

        return new String(arr);
    }
}