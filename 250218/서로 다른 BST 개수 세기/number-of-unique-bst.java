import java.util.Scanner;

public class Main {
    public static final int UNUSED = -1;
    public static final int MAX_NUM = 19;
    
    public static int[] memo = new int[MAX_NUM + 1];
    
    public static void initializeMemo() {
        for(int i  = 0; i <= MAX_NUM; i++)
            memo[i] = UNUSED;
    }
    
    public static int numOfUniqueBST(int n) {
        if(memo[n] != UNUSED)
            return memo[n];
    
        if(n <= 1)
            return 1;
    
        int numberOfUniqueBst = 0;
        for(int i = 0; i < n; i++)
            numberOfUniqueBst += numOfUniqueBST(i) * numOfUniqueBST(n - i - 1);
    
        return memo[n] = numberOfUniqueBst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        initializeMemo();

        System.out.print(numOfUniqueBST(n));
    }
}
