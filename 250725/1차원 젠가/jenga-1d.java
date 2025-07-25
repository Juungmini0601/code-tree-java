import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int[] arr;
    public static final int EMPTY = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        for(int i = 0; i < 2; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            remove(start, end);
        }

        long count = Arrays.stream(arr).filter(elem -> elem > 0).count();
        System.out.println(count);

        for(int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void remove(int start, int end) {
        for(int i = start; i <= end; i++) {
            arr[i] = EMPTY;
        }

        int[] temp = new int[n];
        int tempIndex = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] != EMPTY) {
                temp[tempIndex++] = arr[i];
            }
        }

        arr = temp;
    }

    public static void input() {
        n = sc.nextInt();;
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }
}