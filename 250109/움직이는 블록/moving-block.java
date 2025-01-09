import java.util.Scanner;

public class Main {
    public static final int MAX_N = 10000;

    public static int n;
    public static int[] blocks = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            blocks[i] = sc.nextInt();

        // 전체 블럭 수를 셉니다.
        int sumOfBlocks = 0;
        for(int i = 0; i < n; i++)
            sumOfBlocks += blocks[i];
        
        // 평균 블럭 수 보다 더 큰 블럭에 대해서만
        // 그 차이만큼 옮겨주면 됩니다.
        int avg = sumOfBlocks / n;
        int ans = 0;
        for(int i = 0; i < n; i++)
            if(blocks[i] > avg)
                ans += blocks[i] - avg;

        System.out.print(ans);
    }
}