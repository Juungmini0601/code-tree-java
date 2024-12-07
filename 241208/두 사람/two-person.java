import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int age1 = Integer.parseInt(st.nextToken());
        char c1 = st.nextToken().charAt(0);
        
        st = new StringTokenizer(br.readLine());
        int age2 = Integer.parseInt(st.nextToken());
        char c2 = st.nextToken().charAt(0);

        if(check(age1, c1) || check(age2, c2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean check(int age, char c) {
        return c == 'M' && age >= 19;
    }
}