import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        // k = 1;
        // n = 20;
        Developer[] developers = new Developer[n+1];

        for(int i = 1; i <= n; i++) {
            developers[i] = new Developer(i, new int[n+1]);
        }
        
        for(int i = 0; i < k; i++) {
            int[] arr = new int[n];
            // arr = new int[]{17 ,6 ,5 ,12 ,7 ,11 ,14 ,15 ,18 ,16 ,20 ,4 ,13 ,9 ,10 ,3 ,8 ,2 ,19 ,1};
            for(int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            for(int j = 0; j < n; j++) {
                int number = arr[j];

                for(int l = j + 1; l < n; l++) {
                    developers[number].wins[arr[l]]++;
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            // System.out.println(String.format("%d번: %s", i, Arrays.toString(developers[i].wins)));

            for(int j = 1; j <= n; j++) {
                if(j == i) {
                    continue;
                }
                
                if(developers[i].wins[j] == k) {
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