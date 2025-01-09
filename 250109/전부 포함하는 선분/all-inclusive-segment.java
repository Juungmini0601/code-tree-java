import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] segments = new int[n][2];

        // 선분 입력 받기
        for (int i = 0; i < n; i++) {
            segments[i][0] = scanner.nextInt(); // x1
            segments[i][1] = scanner.nextInt(); // x2
        }

        // 시작점 기준으로 정렬
        Arrays.sort(segments, Comparator.comparingInt(a -> a[0]));

        // 전체 선분의 최소 시작점과 최대 끝점 구하기
        int globalMinStart = Integer.MAX_VALUE;
        int globalMaxEnd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            globalMinStart = Math.min(globalMinStart, segments[i][0]);
            globalMaxEnd = Math.max(globalMaxEnd, segments[i][1]);
        }

        // 최소 길이를 초기화 (전체 선분 포함하는 경우)
        int minLength = globalMaxEnd - globalMinStart;

        // 각 선분을 제거했을 때 최소 길이 계산
        for (int i = 0; i < n; i++) {
            int minStart = Integer.MAX_VALUE;
            int maxEnd = Integer.MIN_VALUE;

            // i번째 선분을 제외한 나머지 선분들의 최소 시작점과 최대 끝점 구하기
            for (int j = 0; j < n; j++) {
                if (j == i) continue; // i번째 선분 제외
                minStart = Math.min(minStart, segments[j][0]);
                maxEnd = Math.max(maxEnd, segments[j][1]);
            }

            // 새로운 길이 계산
            int length = maxEnd - minStart;
            minLength = Math.min(minLength, length);
        }

        // 결과 출력
        System.out.println(minLength);

        scanner.close();
    }
}
