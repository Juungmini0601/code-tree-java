import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = -1;
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n - 2; i++) {
            for(int j = i+1; j < n -1; j++) {
                for(int k = j+1; k < n; k++) {
                    if(carry(arr[i], arr[j], arr[k])) continue;
                    ans = Math.max(ans, arr[i] + arr[j] + arr[k]);
                }
            }
        }

        System.out.println(ans);
    }

    public static boolean carry(int num1, int num2, int num3) {
        String sNum1 = "" + num1;
        String sNum2 = "" + num2;
        String sNum3 = "" + num3;

        int index1 = sNum1.length()-1;
        int index2 = sNum2.length()-1;
        int index3 = sNum3.length()-1;

        while(true) {
            if(index1 < 0 && index2 < 0 && index3 < 0) {
                break;
            }

            int n1 = index1 < 0 ? 0 : sNum1.charAt(index1) - '0';
            int n2 = index2 < 0 ? 0 : sNum2.charAt(index2) - '0';
            int n3 = index3 < 0 ? 0 : sNum3.charAt(index3) - '0';

            int sum = n1 + n2 + n3;
            if(sum >= 10) return true;

            if(index1 >= 0) index1--;
            if(index2 >= 0) index2--;
            if(index3 >= 0) index3--;
        }

        return false;
    }
}