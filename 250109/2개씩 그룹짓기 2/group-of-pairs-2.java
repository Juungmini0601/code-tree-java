import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[2 * n];
        
        // 배열 입력
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 배열 정렬
        Arrays.sort(arr);



        // 두 원소의 차이의 최솟값을 최대화
        long minDiff = Long.MAX_VALUE; // 최대값으로 초기화

        for (int i = 0; i < n; i++) {
            minDiff = Math.min(minDiff, (long) arr[n + i] - arr[i]);
        }

        System.out.println(minDiff);

        scanner.close();
    }
}
