import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, m = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        print(n, m);
    }

    public static void print(final int row, final int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print('1');
            }
            System.out.println();
        }
    }
}