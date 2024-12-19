import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();
        
        int endIndex = n;

        while(endIndex > 0) {
            int maxIndex = 0;

            for(int i = 0; i < endIndex; i++) {
                if(arr[maxIndex] < arr[i]) {
                    maxIndex = i;
                }
            }

            endIndex = maxIndex;
            sb.append(maxIndex + 1).append(" ");
        }

        System.out.println(sb);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}