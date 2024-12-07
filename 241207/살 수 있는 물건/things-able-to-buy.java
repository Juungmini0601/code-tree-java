import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        if (n >= 3000) {
            System.out.println("book");
        } 
        else if(n >= 1000) {
            System.out.println("mask");
        }
        else {
            System.out.println("no");
        }
    }
}