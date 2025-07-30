import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Integer> answer = new ArrayList<>();
    public static int n, count = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        solve(0);
        System.out.println(count);
    }

    public static boolean check() {
        for(int i = 0; i < answer.size(); i += answer.get(i)) {
            if (i + answer.get(i) - 1 >= n) {
                return false;
            }

            for(int j = i; j < i + answer.get(i); j++) {
                if (answer.get(j) != answer.get(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void solve(int cur) {
        if (cur == n) {
            if (check()) {
                count++;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            answer.add(i);
            solve(cur + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void input() {
        n = sc.nextInt();
    }
}