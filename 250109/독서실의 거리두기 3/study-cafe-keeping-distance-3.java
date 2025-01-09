import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();
        String seats = scanner.next();

        // Step1. 최적의 위치 찾기
        int maxDist = 0;
        int maxI = -1, maxJ = -1;

        for (int i = 0; i < n; i++) {
            if (seats.charAt(i) == '1') {
                for (int j = i + 1; j < n; j++) {
                    if (seats.charAt(j) == '1') {
                        // 1 간의 쌍을 골랐을 때 두 좌석 간의 거리를 갱신
                        if (j - i > maxDist) {
                            maxDist = j - i;
                            maxI = i;
                            maxJ = j;
                        }
                        // 인접한 쌍을 찾았으므로 빠져나옵니다.
                        break;
                    }
                }
            }
        }

        // Step2. 최적의 위치에 1을 놓기
        StringBuilder updatedSeats = new StringBuilder(seats);
        updatedSeats.setCharAt((maxI + maxJ) / 2, '1');

        // Step3. 가장 가까운 1 간의 쌍 찾기
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (updatedSeats.charAt(i) == '1') {
                for (int j = i + 1; j < n; j++) {
                    if (updatedSeats.charAt(j) == '1') {
                        ans = Math.min(ans, j - i);
                        // 인접한 쌍을 찾았으므로 빠져나옵니다.
                        break;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(ans);

    }
}
