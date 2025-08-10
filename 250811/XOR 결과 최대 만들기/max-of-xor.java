import java.util.Scanner;

public class Main {

    public static final int MAX_NUM = 20;

    public static int n, m;
    public static int[] A = new int[MAX_NUM];

    public static int ans;

    public static void findMaxXor(int currentIndex, int cnt, int currentVal) {
        if (cnt == m) {
            ans = Math.max(ans, currentVal);
            return;
        }
        // 개수가 모자란 경우
        if (currentIndex >= n || n - currentIndex < m - cnt) {
            return;
        }

        // 현재 인덱스의 수를 포함하는 경우
        findMaxXor(currentIndex + 1, cnt + 1, currentVal ^ A[currentIndex]);
        // 현재 인덱스의 수를 포함하지 않는 경우
        findMaxXor(currentIndex + 1, cnt, currentVal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        findMaxXor(0, 0, 0);
        System.out.println(ans);
    }
}