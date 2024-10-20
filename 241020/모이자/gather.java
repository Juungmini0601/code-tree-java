import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            min = Math.min(moveTo(arr, i), min);
        }

        System.out.println(min);
    }

    public static int moveTo(int[] arr, int num) {
        int ret = 0;

        for(int i = 0; i < arr.length; i++) {
            ret += Math.abs(i - num) * arr[i];
        }

        return ret;
    }
}