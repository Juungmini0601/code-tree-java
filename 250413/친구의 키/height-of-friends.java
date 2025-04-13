import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, m;
    
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static Stack<Integer> reversedOrder = new Stack<>();
    
    // DFS 탐색을 진행합니다.
    public static void dfs(int x) {
        // x에서 갈 수 있는 모든 곳을 탐색합니다.
        // 단, 방문한 적이 없는 경우에만 진행합니다.
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
    
            if(!visited[y]) {
                visited[y] = true;
                dfs(y);
            }
        }
    
        // 퇴각 직전에
        // 현재 노드 번호를 stack에 넣어줍니다.
        reversedOrder.add(x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();

        // 인접리스트로 관리합니다.
        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            edges[x].add(y);   
        }

        // DFS 탐색을 진행합니다.
        // 단, 방문표시가 되지 않은 모든 곳을 시작으로 하여
        // DFS를 진행해야 합니다.
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }

        // 위상정렬 순서대로 출력합니다.
        // stack에 들어있는 순서를 거꾸로 출력해주면 됩니다.
        while(!reversedOrder.isEmpty())
            System.out.print(reversedOrder.pop() + " ");
    }
}
