import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final int MAX_N = 8;

    public static int n;
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static List<Integer> selected = new ArrayList<>();

    public static void getPermutation(int cnt) {
        if(cnt == n) {
            for(int i = 0; i < selected.size(); i++) {
                System.out.print(selected.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected.add(i);

            getPermutation(cnt + 1);

            selected.remove(selected.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        getPermutation(0);
    }
}