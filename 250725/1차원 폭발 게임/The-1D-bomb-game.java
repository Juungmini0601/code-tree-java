import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static int n, m;
    public static final int EMPTY = 0;
    public static final int MARK = -1;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        while (check()) {
            int[] temp = new int[n];
            int tempIndex = 0;

            for(int i = 0; i < n; i++) {
                if(arr[i] != MARK && arr[i] != EMPTY) {
                    temp[tempIndex++] = arr[i];
                }
            }

            arr = temp;
        }

        long count = Arrays.stream(arr).filter(elem -> elem > 0).count();
        System.out.println(count);

        for(int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }


    // 배열을 순회하면서 M개 이상 연속인 숫자를 찾아서, 마킹하기
    public static boolean check() {
        boolean flag = false;

        int startIndex = 0;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == EMPTY) {
                break;
            }

            if (arr[i] == arr[i - 1]) {
                cnt++;
                continue;
            }

            // 숫자가 다른 경우인데 그 개수가 m이상인 경우면 마킹
            if (cnt >= m) {
                flag = true;
                for (int j = startIndex; j < i; j++) {
                    arr[j] = MARK;
                }
            }

            startIndex = i;
            cnt = 1;
        }

        // 마지막 숫자에 대한 처리 필요
        if (cnt >= m) {
            flag = true;
            for (int j = startIndex; j < n; j++) {
                arr[j] = MARK;
            }
        }

        return flag;
    }

    public static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }
}
