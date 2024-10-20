import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                double sum = 0;

                for(int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                double avg = sum / (j - i + 1);
                if(contain(arr, i, j, avg)) {
                    cnt++;
                    // System.out.println(String.format("%d %d %f", i, j, avg));
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean contain(int[] arr, int start, int end, double value) {
        for(int i = start; i <= end; i++) {
            if((double) arr[i] == value) return true;
        }

        return false;
    }
}