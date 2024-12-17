import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int q;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());

            if(query == 1) {
                int a = Integer.parseInt(st.nextToken());
                sb.append(arr[a]).append("\n");
            }
            else if(query == 2) {
                int b = Integer.parseInt(st.nextToken());
                int k = -1;

                for(int j = 1; j <= n; j++) {
                    if(arr[j] == b) {
                        k = j;
                        break;
                    }
                }

                sb.append(k == -1 ? 0 : k).append("\n");
            }
            else {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                for(int j = s; j <= e; j++) {
                    sb.append(arr[j]).append(" ");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }   

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}