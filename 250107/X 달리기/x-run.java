import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt(); // 거리 입력 받기
        
        int currPos = 0; // 현재 위치
        int currSpeed = 1; // 현재 속도
        int sumTime = 0; // 총 시간

        while (true) {
            currPos += currSpeed; // 현재 속도로 이동
            sumTime += 1; // 시간 증가
            currSpeed += 1; // 속도 증가

            if (currPos == X) {
                break; // 목표 지점에 도달하면 종료
            }

            // 증가 거리 계산
            int increaseSum = 0;
            for (int i = 0; i < currSpeed; i++) {
                increaseSum += i; // 증가 거리 합계
            }

            // 다음 위치가 목표 지점을 초과할 경우 속도 감소
            if (X - (currPos + currSpeed) < increaseSum) {
                currSpeed -= 1;
            }

            // 현재 속도로 정지할 경우 거리 계산
            int staySum = 0;
            for (int i = 0; i < currSpeed; i++) {
                staySum += i; // 정지 거리 합계
            }

            // 다음 위치가 목표 지점을 초과할 경우 속도 감소
            if (X - (currPos + currSpeed) < staySum) {
                currSpeed -= 1;
            }
        }

        System.out.println(sumTime); // 최종 시간 출력
    }
}
