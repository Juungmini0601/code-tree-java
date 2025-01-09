import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(nums);

        // 양수 3개 곱하기
        int temp = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // 음수 2개 + 양수 1개 곱하기
        int temp2 = nums[0] * nums[1] * nums[n - 1];

        // 두 값 중 큰 값을 출력
        System.out.println(Math.max(temp, temp2));

        sc.close();
    }
}
