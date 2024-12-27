import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n1; i++) {
            if(contains(arr1, arr2, i)) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }

    public static boolean contains(int[] arr1, int[] arr2, int arr1Index) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if(arr1Index + n2 > n1) return false;

        for(int i = 0; i < n2; i++) {
            if(arr1[arr1Index + i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
