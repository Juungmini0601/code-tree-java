import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        char[] arr = new char[1001];

        for(int i = 0 ; i < t; i++) {
            char c = sc.next().charAt(0);
            int idx = sc.nextInt();
            arr[idx] = c;
        }
        
        int cnt = 0;
        for(int i = a; i <= b; i++) {
            int d1 = find(arr, i, 'S');
            int d2 = find(arr, i, 'N');
            
            if(d1 <= d2) {
                cnt++;
                // System.out.println(i);
            }
        }

        System.out.println(cnt);
    }

    public static int find(char[] arr, int idx, char c) {
        int ret = 0;

        while(ret <= 1000) {
            int right = idx + ret;
            int left = idx - ret;

            if(right > 1000) {
                right = 1000;
                // break;
            }

            if(left < 1) {
                left = 1;
                // break;
            }

            if(arr[right] == c || arr[left] == c) {
                return ret;
            }

            ret++;
        }

        return -1;
    }
}

// 특별한 위치 특정 위치로부터 가장 가까이에 있는 알파벳 S의 거리 d1
// 특정 위치로부터 가장 가까이에 있는 N까지의 거리 d2보다 같거나 작은 경우 특별한 위치