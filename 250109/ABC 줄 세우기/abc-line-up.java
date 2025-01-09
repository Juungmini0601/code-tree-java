import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        ArrayList<Integer> people = new ArrayList<>();

        // 입력 처리
        for (int i = 0; i < N; i++) {
            char ele = scanner.next().charAt(0);
            people.add(ele - 'A'); // 'A'의 ASCII 값을 빼서 0부터 시작하는 인덱스로 변환
        }

        int count = 0;

        // 길이가 1이면 움직일 필요 없음
        if (people.size() == 1) {
            System.out.println(0);
        } else {
            // 각 위치에 올바로 서있지 않으면 올바른 위치로 옮겨줌
            for (int i = 0; i < N; i++) {
                int orderIndex = people.indexOf(i);
                int temp = people.get(orderIndex);

                // orderIndex가 서있는 위치가 있어야 할 위치(i)보다 뒤에 있는 경우
                if (orderIndex > i) {
                    for (int j = orderIndex; j > i; j--) {
                        people.set(j, people.get(j - 1));
                    }
                    people.set(i, temp);
                    count += Math.abs(orderIndex - i);
                }
            }
            System.out.println(count);
        }

        scanner.close();
    }
}
