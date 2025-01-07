import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] birds = new int[11];

    public static void main(String[] args) throws Exception {
        // 비둘기 초기 위치 지정
        for(int i = 1; i <= 10; i++) {
            birds[i] = -1;
        }
        // 비둘기 이동 숫자 확인
        n = Integer.parseInt(br.readLine());
        int ans = 0;

        // 비둘기 이동을 보면서 count
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            // 새가 처음 관측 된 경우
            if(birds[index] == -1) {
                birds[index] = position;
            } else {
                if(birds[index] != position) {
                    ans++;
                }
                birds[index] = position;
            }
        }

        System.out.println(ans);
    }
}