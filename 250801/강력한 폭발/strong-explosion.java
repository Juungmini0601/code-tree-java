import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int n, count;
    public static List<Integer> selected = new ArrayList<>();
    public static List<Pos> positions = new ArrayList<>();
    public static int[][] grid;
    public static Scanner sc = new Scanner(System.in);

    public static int[][] dx = {
            {0, 0, 0, 0, 0},
            {-2, -1, 0, 1, 2},// 1
            {-1, 0, 0, 1, 0}, // 2
            {-1, -1, 0, 1, 1} // 3
    };

    public static int[][] dy = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}, // 1
            {0, 1, 0, 0, -1},// 2
            {-1, 1, 0, 1, -1}// 3
    };

    public static void main(String[] args) {
        input();
        select(0);
        System.out.println(count);
    }

    public static void select(int idx) {
        if (idx == positions.size()) {
            calc();
            return;
        }

        for(int i = 1; i <= 3; i++) {
            selected.add(i);
            select(idx + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public static void calc() {
        int[][] copy = copyArray();

        for (int i = 0; i < positions.size(); i++) {
            Pos pos = positions.get(i);
            int type = selected.get(i);

            for (int j = 0; j < 5; j++) {
                int nx = pos.x + dx[type][j];
                int ny = pos.y + dy[type][j];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    copy[nx][ny] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] == 1) {
                    cnt++;
                }
            }
        }

        count = Math.max(count, cnt);
    }

    public static int[][] copyArray() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }

    public static void input() {
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 1) {
                    positions.add(new Pos(i, j));
                }
            }
        }
    }


















}