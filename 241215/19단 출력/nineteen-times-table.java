import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= 19; i++) {
            for(int j = 1; j <= 19; j++) {
                sb.append(String.format("%d * %d = %d ", i, j, i * j));
                
                if(j % 2 == 1 && j != 19) {
                    sb.append("/ ");
                } else {
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}