import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];

        for(int i = 0; i < 3; i++) {
            arr1[i] = sc.nextInt();
        }

        for(int i = 0; i < 3; i++) {
            arr2[i] = sc.nextInt();
        }
        int cnt = 0;
        // 1과 9사이의 거리 (num1 - num2 + n) % n
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    int[] target = {i, j, k};
                    if(check(arr1, target, n) || check(arr2, target, n)) {
                        cnt++;
                    }
                }
            }
        }
        
        System.out.println(cnt);
    }
    
    public static boolean check(int[] arr1, int[] arr2, int n) {
        for(int i = 0; i < 3; i++) {
            int distance1 = (arr1[i] - arr2[i] + n) % n;
            int disatnce2 = (arr2[i] - arr1[i] + n) % n;
            int distance = Math.min(distance1, disatnce2);
            if(distance > 2) {
                // System.out.println(Arrays.toString(arr1) + " " + Arrays.toString(arr2));
                return false;
            }
        }
        // System.out.println(Arrays.toString(arr1) + " " + Arrays.toString(arr2));
        return true;
    }
}