import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] poses = new int[3]; // 3명의 위치를 저장할 배열

        // 위치 입력 받기
        for (int i = 0; i < 3; i++) {
            poses[i] = scanner.nextInt();
        }

        // 입력받은 위치를 정렬
        Arrays.sort(poses);

        // 두 위치 간의 차이 계산
        int diff1 = poses[1] - poses[0];
        int diff2 = poses[2] - poses[1];

        // 최대 차이에서 1을 빼고 출력
        System.out.println(Math.max(diff1, diff2) - 1);

        scanner.close();
    }
}
