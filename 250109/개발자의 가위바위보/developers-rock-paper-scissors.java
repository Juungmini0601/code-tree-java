import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // 승리 조건을 체크하는 함수
    static int countWins(List<int[]> games, int rock, int scissors, int paper) {
        int wins = 0;
        for (int[] game : games) {
            int player1 = game[0];
            int player2 = game[1];

            // 가위 바위 보의 승리 조건
            if ((player1 == scissors && player2 == paper) || 
                (player1 == rock && player2 == scissors) || 
                (player1 == paper && player2 == rock)) {
                wins++;
            }
        }
        return wins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<int[]> games = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int player1 = scanner.nextInt();
            int player2 = scanner.nextInt();
            games.add(new int[]{player1, player2});
        }

        int maxWins = 0;

        // 1, 2, 3을 각각 가위, 바위, 보로 매칭하는 모든 경우 확인
        for (int rock = 1; rock <= 3; rock++) {
            for (int scissors = 1; scissors <= 3; scissors++) {
                if (scissors == rock) continue; // 같은 숫자 사용 불가
                for (int paper = 1; paper <= 3; paper++) {
                    if (paper == rock || paper == scissors) continue; // 같은 숫자 사용 불가

                    // 승리 조건 확인
                    maxWins = Math.max(maxWins, countWins(games, rock, scissors, paper));
                }
            }
        }

        System.out.println(maxWins);
    }
}
