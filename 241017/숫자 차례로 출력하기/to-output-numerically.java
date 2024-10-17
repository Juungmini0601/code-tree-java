import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printUp(n);
        System.out.println();
        printDown(n);
    }

    public static void printUp(int n) {
        if(n <= 0) {
            return;
        }
        printUp(n-1);
        System.out.print(n + " ");
    }

    public static void printDown(int n) {
        if(n <= 0) {
            return;
        }
        System.out.print(n + " ");
        printDown(n-1);
    }
}