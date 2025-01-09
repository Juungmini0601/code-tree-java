import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();
        String seats = scanner.next();
        scanner.close();

        // Step1-1. 최적의 위치 찾기
        int maxDist = 0;
        int maxI = -1, maxJ = -1;

        for (int i = 0; i < n; i++) {
            if (seats.charAt(i) == '1') {
                for (int j = i + 1; j < n; j++) {
                    if (seats.charAt(j) == '1') {
                        if (j - i > maxDist) {
                            maxDist = j - i;
                            maxI = i;
                            maxJ = j;
                        }
                        break; // 인접한 쌍을 찾았으므로 빠져나오기
                    }
                }
            }
        }

        // Step1-2. 최적의 위치 찾기 (예외 처리)
        int maxDist2 = -1;
        int maxIdx = -1;

        // 맨 앞 좌석이 비어있을 때
        if (seats.charAt(0) == '0') {
            int dist = 0;
            for (int i = 0; i < n; i++) {
                if (seats.charAt(i) == '1') break;
                dist++;
            }
            if (dist > maxDist2) {
                maxDist2 = dist;
                maxIdx = 0;
            }
        }

        // 맨 뒷 좌석이 비어있을 때
        if (seats.charAt(n - 1) == '0') {
            int dist = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (seats.charAt(i) == '1') break;
                dist++;
            }
            if (dist > maxDist2) {
                maxDist2 = dist;
                maxIdx = n - 1;
            }
        }

        // Step2. 최적의 위치에 1을 놓기
        StringBuilder updatedSeats = new StringBuilder(seats);
        if (maxDist2 >= maxDist / 2) {
            updatedSeats.setCharAt(maxIdx, '1');
        } else {
            updatedSeats.setCharAt((maxI + maxJ) / 2, '1');
        }

        // Step3. 가장 가까운 1 간의 쌍 찾기
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (updatedSeats.charAt(i) == '1') {
                for (int j = i + 1; j < n; j++) {
                    if (updatedSeats.charAt(j) == '1') {
                        ans = Math.min(ans, j - i);
                        break; // 인접한 쌍을 찾았으므로 빠져나오기
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(ans);
    }
}
