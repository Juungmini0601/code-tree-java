import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] a;
    public static int[] b;
    public static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] move = new int[n];
        for(int i = 0; i < n; i++) {
            move[i] = a[i] - b[i];
        }

        int totalDistance = 0;
        int surplus = 0; // 이동해야 할 사람 수의 누적

        for (int i = 0; i < n; ++i) {
            surplus += move[i];
            totalDistance += Math.abs(surplus); // 누적 이동 거리
        }

        System.out.println(totalDistance);
    }
}