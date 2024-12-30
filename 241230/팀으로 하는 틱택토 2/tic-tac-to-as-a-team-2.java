import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] arr = new int[3][3];
    public static Set<String> ans = new HashSet<>();

    public static void main(String[] args) throws Exception {
        input();

        // 가로에서 이길 수 있었던경우의 수
        for(int i = 0; i < 3; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < 3; j++) {
                set.add(arr[i][j]);
            }

            if(set.size() == 2) {
                String ret = "";

                for(int x: set) {    
                    ret += x;
                }

                ans.add(ret);
                StringBuilder sb = new StringBuilder(ret);
                ans.add(sb.reverse().toString());
            }
        }

        // 세로에서 이길 수 있었던경우의 수
        for(int i = 0; i < 3; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < 3; j++) {
                set.add(arr[j][i]);
            }

            if(set.size() == 2) {
                String ret = "";

                for(int x: set) {    
                    ret += x;
                }

                ans.add(ret);
                StringBuilder sb = new StringBuilder(ret);
                ans.add(sb.reverse().toString());
            }
        }

        Set<Integer> set = new HashSet<>();
        set.add(arr[2][0]);
        set.add(arr[1][1]);
        set.add(arr[0][2]);

        if(set.size() == 2) {
            String ret = "";

            for(int x: set) {    
                ret += x;
            }

            ans.add(ret);
            StringBuilder sb = new StringBuilder(ret);
            ans.add(sb.reverse().toString());
        }

        // \ 대각선에서 이길 수 있었던 경우의 수
        set = new HashSet<>();
        set.add(arr[0][0]);
        set.add(arr[1][1]);
        set.add(arr[2][2]);

        if(set.size() == 2) {
            String ret = "";

            for(int x: set) {
                ret += x;
            }

            ans.add(ret);
            StringBuilder sb = new StringBuilder(ret);
            ans.add(sb.reverse().toString());
        }

        System.out.println(ans.size() / 2);
    }

    public static void input() throws Exception {
        for(int i = 0; i < 3; i++) {
            String str = br.readLine();
            for(int j = 0; j < 3; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
    }
}