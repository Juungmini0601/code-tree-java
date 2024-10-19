import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cur = 1000;
        int n = sc.nextInt();
        int[] arr = new int[2001];

        for(int i = 0; i < n; i++) {
            int distance = sc.nextInt();
            String dir = sc.next();

            if(dir.equals("R")) {
                while(distance > 1) {
                    cur++;
                    arr[cur]++;
                    distance--;
                }
            } else {
                while(distance > 1) {
                    cur--;
                    arr[cur]++;
                    distance--;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 2) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}