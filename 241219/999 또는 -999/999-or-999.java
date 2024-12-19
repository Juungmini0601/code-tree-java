import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] arr = new int[100];

    public static void main(String[] args) throws Exception {
        input();
        int min = arr[0];
        int max = arr[0];

        for(int i = 1; i < 100; i++) {
            if(arr[i] == 999 || arr[i] == -999) {
                break;
            }
            
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        

        System.out.printf("%d %d", max, min);
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        int curIndex = 0;

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            arr[curIndex++] = num;

            if(num == 999 || num == -999) {
                break;
            }
        }
    }
}