import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Line {
        int start;
        int end;

        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int n, ans;
    public static boolean[] visited = new boolean[1001];
    public static List<Line> lines = new ArrayList<>();
    public static List<Integer> selected = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        select(0);
        System.out.println(ans);
    }

    public static void select(int cur) {
        if (cur == n) {
            if (possible()) {
                ans = Math.max(ans, selected.size());
            }

            return;
        }

        // 선택한 경우
        selected.add(cur);
        select(cur + 1);
        selected.remove(selected.size() - 1);
        // 선택하지 않은 경우
        select(cur + 1);
    }

    public static boolean possible() {
        Arrays.fill(visited, false);
        for (int i = 0; i < selected.size(); i++) {
            Line line = lines.get(selected.get(i));
            for (int j = line.start; j <= line.end; j++) {
                if (visited[j]) {
                    return false; // 이미 방문한 점이 있다면 불가능
                }
                visited[j] = true;
            }
        }
        return true; // 모든 선택된 선들이 겹치지 않음
    }

    public static void input() {
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lines.add(new Line(start, end));
        }
    }
}