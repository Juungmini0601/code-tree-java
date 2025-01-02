
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[200];

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            arr1[num]++;
        }        

        for(int a = 1; a <= 40; a++) {
            for(int b = a; b <= 40; b++) {
                for(int c = b; c <= 40; c++) {
                    for(int d = c; d <= 40; d++) {
                        int[] arr2 = new int[200];
                        arr2[a]++;
                        arr2[b]++;
                        arr2[c]++;
                        arr2[d]++;
                        
                        arr2[a+b]++;
                        arr2[b+c]++;
                        arr2[c+d]++;
                        arr2[d+a]++;
                        arr2[a+c]++;
                        arr2[b+d]++;
                        
                        arr2[a+b+c]++;
                        arr2[a+b+d]++;
                        arr2[a+c+d]++;
                        arr2[b+c+d]++;

                        arr2[a+b+c+d]++;

                        if(check(arr1, arr2)) {
                            System.out.println(a + " " + b + " " + c + " " + d);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static boolean check(int[] arr1, int[] arr2) {
        int len = arr1.length;

        for(int i = 0; i < len; i++) {
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}