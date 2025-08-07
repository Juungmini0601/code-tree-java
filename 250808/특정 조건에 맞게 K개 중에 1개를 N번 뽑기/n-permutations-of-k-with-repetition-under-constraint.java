import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1 ~ M 윷놀이판
 * K개의 말이 1번 지점에 있음.
 * N번의 턴에 걸쳐 숫자가
 */
public class Main {

    public static int k, n;
    public static List<Integer> selected = new ArrayList<>();

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        k = sc.nextInt();
        n = sc.nextInt();

        permutation(0);
    }

    public static void permutation(int cnt) {
        if (cnt == n) {
            for(int i = 0; i < selected.size(); i++) {
                System.out.print(selected.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= k; i++) {
            if (cnt >= 2 && i == selected.get(cnt - 2) && i == selected.get(cnt - 1)) {
                continue;
            }

            selected.add(i);
            permutation(cnt + 1);
            selected.remove(selected.size() - 1);
        }
    }
}