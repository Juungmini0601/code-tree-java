import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n1;
    public static int n2;
    public static int[] arr1;
    public static int[] arr2;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void solve() throws Exception {
        StringBuilder sb = new StringBuilder();

        if(n1 < n2) {
            System.out.println("No");
            return;
        }

        for(int i = 0; i < n1 - n2; i++) {
            if(check(i)) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }

    public static boolean check(int index) {
        for(int i = 0; i < n2; i++) {
            if(arr1[index + i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        arr1 = new int[n1];
        arr2 = new int[n2];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
    }
}