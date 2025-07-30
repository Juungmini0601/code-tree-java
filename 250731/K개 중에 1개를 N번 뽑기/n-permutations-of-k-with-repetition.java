import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Integer> answer = new ArrayList<>();
    public static int n, k;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        solve(0);
    }

    public static void solve(int cur) {
        if (cur == n) {
            for(int i = 0; i < n; i++) {
                System.out.print(answer.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            answer.add(i);
            solve(cur + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void input() {
        k = sc.nextInt();
        n = sc.nextInt();
    }
}