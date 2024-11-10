import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static int n;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        heapSort();

        for(int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void input() {
        n = sc.nextInt();
        arr = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void heapify(int n, int index) {
        int largestIndex = index;
        int left = 2 * index;
        int right = 2 * index + 1;

        if(left <= n && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }

        if(right <= n && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }

        if(largestIndex != index) {
            swap(largestIndex, index);
            heapify(n, largestIndex);
        }
    }

    public static void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void heapSort() {
        for(int i = n / 2; i >= 1; i--) {
            heapify(n, i);
        }

        for(int i = n; i >=1; i--) {
            swap(1, i);
            heapify(i - 1, 1);
        }
    }
}