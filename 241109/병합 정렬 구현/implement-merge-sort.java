import java.util.Scanner;

public class Main {

    public static int[] mergedArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        mergedArr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n-1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        // int[] mergedArr = new int[arr.length];
        int i = start;
        int j = mid + 1;
        int k = i;

        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                mergedArr[k] = arr[i];
                i++;
            } else {
                mergedArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            mergedArr[k] = arr[i];
            i++;
            k++;
        }

        while(j <= end) {
            mergedArr[k] = arr[j];
            j++;
            k++;
        }
        
        for(int x = start; x <= end; x++) {
            arr[x] = mergedArr[x];
        }
    }
}