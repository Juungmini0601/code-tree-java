import java.util.ArrayList;
import java.util.Scanner;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int COIN_NUM = 9;
    public static final int MAX_N = 20;

    public static int n;
    public static int m = 3;

    public static char[][] grid = new char[MAX_N][MAX_N];

    public static ArrayList<Pair> coins = new ArrayList<>();
    public static ArrayList<Pair> selectedPos = new ArrayList<>();

    public static Pair startPos;
    public static Pair endPos;

    public static int ans = INT_MAX;

    public static int dist(Pair a, Pair b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public static int calc() {
        int numMoves = dist(startPos, selectedPos.get(0));
        for(int i = 0; i < m - 1; i++) {
            numMoves += dist(selectedPos.get(i), selectedPos.get(i + 1));
        }

        numMoves += dist(selectedPos.get(m - 1), endPos);
        return numMoves;
    }

    public static void findMinMoves(int currentIndex, int count) {
        if(count == m) {
            ans = Math.min(ans, calc());
            return;
        }

        if(currentIndex >= coins.size()) {
            return;
        }

        selectedPos.add(coins.get(currentIndex));
        findMinMoves(currentIndex + 1, count + 1);
        selectedPos.remove(selectedPos.size() - 1);
        // 코인을 선택하지 않는 경우
        findMinMoves(currentIndex + 1, count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
       
        for(int i = 0; i < n; i++) {
            String line = sc.next();
            for(int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
                
                if(grid[i][j] == 'S') {
                    startPos = new Pair(i, j);
                }
                else if(grid[i][j] == 'E') {
                    endPos = new Pair(i, j);
                }
            }
        }

        // 동전을 오름차순으로 각 위치를 넣는다.

        for(int num = 1; num <= COIN_NUM; num++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == num + '0') {
                        coins.add(new Pair(i, j));
                    }
                }
            }
        }
       
        findMinMoves(0, 0);
        
        if(ans == INT_MAX)
            ans = -1;
        
        System.out.print(ans);
    }
}