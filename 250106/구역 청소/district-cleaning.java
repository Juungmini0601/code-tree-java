import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            visit(start, end);
        }
        
        int cnt = 0;
        for(int i = 0; i <= 100; i++) {
            if(visited[i]) cnt++;
        }

        System.out.println(cnt);
    }

    public static void visit(int start, int end) {
        for(int i = start; i < end; i++)
            visited[i] = true;
    }
}