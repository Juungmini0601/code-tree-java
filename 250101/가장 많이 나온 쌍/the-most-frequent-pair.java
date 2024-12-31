import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

import java.util.Map;
import java.util.HashMap;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int m;
    public static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // n, m 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int answer = 0;

        // map에 입력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // min, max
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            String key = "" + min + max;

            int count = map.getOrDefault(key, 0);
            map.put(key, count + 1);
            answer = Math.max(answer, count + 1);
        }

        System.out.println(answer);
    }
}