import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String st = br.readLine();

        boolean containsEe = st.contains("ee");
        boolean containsAb = st.contains("ab");

        System.out.print(containsEe ? "Yes" : "No");
        System.out.print(" ");
        System.out.print(containsAb ? "Yes" : "No");

    }
}