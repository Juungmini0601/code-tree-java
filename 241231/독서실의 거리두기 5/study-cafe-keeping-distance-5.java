import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String str;
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        str = br.readLine();
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        int answerDistance = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                continue;
            }

            arr[i] = 1;
            int distance = findMinDistance();
            answerDistance = Math.max(answerDistance, distance);
            arr[i] = 0;
        }

        System.out.println(answerDistance);
    }

    public static int findMinDistance() {
        int ret = Integer.MAX_VALUE;

        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == 0 || arr[j] == 0) {
                    continue;
                }

                ret = Math.min(ret, Math.abs(i - j));
            }
        }

        // System.out.println(Arrays.toString(arr) + " " + ret);
        return ret;
    }
}