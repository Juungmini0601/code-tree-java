import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        changeArr(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void changeArr(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                arr[i] = arr[i] / 2;
            }
        }
    }
}