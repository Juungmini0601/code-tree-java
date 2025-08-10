import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int n, m;
    public static List<Integer> combination = new ArrayList<>();

    public static void printCombination() {
        for (int i = 0; i < combination.size(); i++) {
            System.out.print(combination.get(i) + " ");
        }
        System.out.println();
    }

    public static void findCombination(int current, int cnt) {
        if (current == n + 1) { 
            if (cnt == m) {
                printCombination();
            }
            return;
        }

        combination.add(current);
        findCombination(current + 1, cnt + 1);
        
        combination.remove(combination.size() - 1);
        findCombination(current + 1, cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        findCombination(1, 0);
    }
}