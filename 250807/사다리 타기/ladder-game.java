import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 사람 수 N 만큼 세로 줄을 긋고 1 ~ N까지의 숫자를 순서대로 적는다.
 * 세로 줄 사이에 가로 줄 M개를 서로 겹치지 않게 긋는다.
 * 세로줄의수 N과 M개의 가로 줄의 상태가 주어졌을 때 가로줄을 적절하게 선택해, 모든 가로줄을 이용했을 때의 결과와 동일하게 되도록 하는 최소 가로 줄의 수를 구하시오.
 * [ai, bi]<- i번째 가로줄이 왼쪽에서 ai번째 새로줄과 ai+1을 이어주며 위에서부터 bi번째 위치에 그어진다.
 */
public class Main {

    public static int n, m;
    public static ArrayList<Pair> lines = new ArrayList<>();
    public static ArrayList<Pair> selectedLines = new ArrayList<>();

    public static int ans = Integer.MAX_VALUE;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            lines.add(new Pair(b, a-1));
        }
        // 가장 위에 있는 선 순서대로 정렬
        Collections.sort(lines);

        findMinLines(0);

        System.out.println(ans);
    }

    public static void findMinLines(int cnt) {
        if (cnt == m) {
            if (possible()) {
                ans = Math.min(ans, selectedLines.size());
            }
            return;
        }

        selectedLines.add(lines.get(cnt));
        findMinLines(cnt+1);
        selectedLines.remove(selectedLines.size()-1);

        findMinLines(cnt+1);
    }

    public static boolean possible() {
        int[] num1 = new int[n];
        int[] num2 = new int[n];

        for(int i = 0; i < n; i++) {
            num1[i] = num2[i] = i;
        }
        // a[i] a[i+1] 사이를 있는 선을 한번 타게 되면 Swap 하면 결과가 되니까!
        for(int i = 0; i < lines.size(); i++) {
            int idx = lines.get(i).y;
            int tmp = num1[idx];
            num1[idx] = num1[idx + 1];
            num1[idx + 1] = tmp;
        }

        for(int i = 0; i < selectedLines.size(); i++) {
            int idx = selectedLines.get(i).y;
            int tmp = num2[idx];
            num2[idx] = num2[idx + 1];
            num2[idx + 1] = tmp;
        }

        for(int i = 0; i < n; i++) {
            if(num1[i] != num2[i]) return false;
        }

        return true;
    }
}

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        if(x != o.x) return x - o.x;
        return y - o.y;
    }
}