import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static int n;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int partition(int start, int end) {
        int pivot = end;
        int lower = start-1;

        for(int higher = start; higher < end; higher++) {
            if(arr[higher] < arr[pivot]) {
                lower++;
                swap(lower, higher);
            }
        }
        
        swap(lower+1, end);
        return lower + 1;
    }

    public static void quickSort(int start, int end){
        if(start < end) {
            int pos = partition(start, end);
            quickSort(start, pos - 1);
            quickSort(pos + 1, end);
        }
    }

    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}