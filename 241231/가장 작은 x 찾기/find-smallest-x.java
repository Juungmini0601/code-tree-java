import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static Range[] ranges;
    public static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        ranges = new Range[n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ranges[i] = new Range(start, end);
        }

        int ans = 1;

        while(true) {
            if(check(ans)) {
                System.out.println(ans);
                return;
            }

            ans++;
        }
    }

    public static boolean check(int x) {
        for(int i = 1; i <= n; i++) {
            x *= 2;
            Range range = ranges[i];

            if(!(range.start <= x && x <= range.end)) {
                return false;
            }
        }

        return true;
    }
}

class Range {
    public int start;
    public int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
}