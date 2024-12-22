import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int q = Integer.parseInt(st.nextToken());
        char[] arr = str.toCharArray();

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                char temp = arr[a-1];
                arr[a-1] = arr[b-1];
                arr[b-1] = temp;
            }
            else {
                char a = st.nextToken().charAt(0);
                char b = st.nextToken().charAt(0);

                for(int j = 0; j < arr.length; j++) {
                    if(arr[j] == a) {
                        arr[j] = b;
                    }
                }
            }

            System.out.println(String.valueOf(arr));
        }
    }
}