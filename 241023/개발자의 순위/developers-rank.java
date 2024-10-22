import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        Developer[] developers = new Developer[n+1];

        for(int i = 1; i <= n; i++) {
            developers[i] = new Developer(i, new int[n+1]);
        }
        
        for(int i = 0; i < k; i++) {
            int[] arr = new int[n];

            for(int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            for(int j = 0; j < n; j++) {
                int number = arr[j];

                for(int l = j + 1; l < n; l++) {
                    developers[number].wins[l]++;
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            //System.out.println(String.format("%d번의 승리 회수: %s", i, Arrays.toString(developers[i].wins)));

            for(int j = 1; j <= n; j++) {
                if(j == i) {
                    continue;
                }
                
                if(developers[i].wins[j] == n-1) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

class Developer {
    int number;
    int[] wins;

    public Developer(int number, int[] wins) {
        this.number = number;
        this.wins = wins;
    }
}