import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt(), n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];

        // a 배열 입력
        for(int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }

        // b 배열 입력
        for(int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }

        System.out.println(checkArray(a, b) ? "Yes" : "No");
    }

    public static boolean checkArray(int[] a, int[] b) {
        if(a.length < b.length) {
            return false;
        }

        for(int i = 0; i < a.length - b.length + 1; i++) {
            if(sameArray(a, b, i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean sameArray(int[] a, int [] b, int startIndex) {
        for(int i = 0; i < b.length; i++) {
            if(a[startIndex + i] != b[i]) return false;
        }
        return true;
    }
}