import java.util.Scanner;

public class Main {
    static final int MAX_NUM = 10000;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int answer = 0;
        // 합의 최소값을 구간으로 검색한다.
        for (int i = 1; i <= MAX_NUM; i++) {
            boolean possible = true;
            // 아무런 구간도 나누지 않으면 섹션은 1개이다.
            int section = 1, sum = 0;
            
            for (int j = 0; j < n; j++) {
                // 특정 원소가 현재 최대값보다 크다면 불가능한 경우이다.
                if (arr[j] > i) {
                    possible = false;
                    break;
                }
                // 현재 원소가 포함되었을 때 구간이 안되면 섹션을 나눠준다.
                if (arr[j] + sum > i) {
                    sum = 0;
                    section++;
                }
                
                sum += arr[j];
            }
            
            if (possible && section <= m) {
                System.out.println(i);
                break;
            }
        }
        
        sc.close();
    }
}
