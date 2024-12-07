import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken()), height = Integer.parseInt(st.nextToken());

        width += 8;
        height *= 3;

        System.out.println(width);
        System.out.println(height);
        System.out.println(width * height);
    }
}