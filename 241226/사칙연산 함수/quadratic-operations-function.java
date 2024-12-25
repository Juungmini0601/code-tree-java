import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        char ops = st.nextToken().charAt(0);
        int b = Integer.parseInt(st.nextToken());

        if(ops == '+') {
            System.out.println(add(a, b));
        }
        else if(ops == '-') {
            System.out.println(minus(a, b));
        }
        else if (ops == '*') {
            System.out.println(multiply(a, b));
        }
        else if(ops == '/') {
            System.out.println(divide(a, b));
        }
        else {
            System.out.println("False");
        }
    }

    public static String add(int a, int b) {
        return String.format("%d + %d = %d", a, b, (a + b));
    }

    public static String minus(int a, int b) {
        return String.format("%d - %d = %d", a, b, (a - b));
    }

    public static String multiply(int a, int b) {
        return String.format("%d * %d = %d", a, b, (a * b));
    }

    public static String divide(int a, int b) {
        return String.format("%d / %d = %d", a, b, (a / b));
    }
}