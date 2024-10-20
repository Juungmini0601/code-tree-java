import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int max = 0;

        for(int i = 0; i < str.length(); i++){
            max = Math.max(max, changeNumber(str, i));
        }

        System.out.println(max);
    }

    public static int changeNumber(String str, int index) {
        char[] arr = str.toCharArray();
        arr[index] = arr[index] == '1' ? '0' : '1';

        int ans = 0;

        for(int i = arr.length - 1, temp = 1; i >= 0; i--, temp *= 2) {
            if(arr[i] == '1') {
                ans += temp;
            }
        }

        return ans;
    }
}