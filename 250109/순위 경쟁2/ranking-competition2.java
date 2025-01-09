import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int scoreA = 0, scoreB = 0;
        int changes = 0;
        String currentHallOfFame = "A B"; // 초기 명예의 전당 상태

        for (int i = 0; i < n; i++) {
            char student = scanner.next().charAt(0);
            int scoreChange = scanner.nextInt();

            // 점수 업데이트
            if (student == 'A') {
                scoreA += scoreChange;
            } else if (student == 'B') {
                scoreB += scoreChange;
            }

            // 현재 최고 점수
            int maxScore = Math.max(scoreA, scoreB);
            String newHallOfFame;

            // 명예의 전당 결정
            if (scoreA == maxScore && scoreB == maxScore) {
                newHallOfFame = "A B";
            } else if (scoreA == maxScore) {
                newHallOfFame = "A";
            } else {
                newHallOfFame = "B";
            }

            // 명예의 전당 상태가 변경되었는지 확인
            if (!newHallOfFame.equals(currentHallOfFame)) {
                changes++;
                currentHallOfFame = newHallOfFame; // 상태 업데이트
            }
        }

        System.out.println(changes); // 결과 출력
        scanner.close();
    }
}
