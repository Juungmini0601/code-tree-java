import java.util.Scanner;

public class Main {
    //  return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.println(checkYear(year));
    }

    public static boolean checkYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}