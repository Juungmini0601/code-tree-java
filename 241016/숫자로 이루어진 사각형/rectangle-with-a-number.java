import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        print(N);
    }

    public static void print(final int n) {
        int cnt = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(cnt + " ");
                cnt++;
                if(cnt >= 10) {
                    cnt = 1;
                }
            }
            System.out.println();
        }
    }
}