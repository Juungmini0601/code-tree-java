import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        WorkTime[] workTimes = new WorkTime[n];

        for(int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            workTimes[i] = new WorkTime(start, end);
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            int[] arr = new int[1001];

            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }

                WorkTime workTime = workTimes[j];
                
                for(int k = workTime.start; k < workTime.end; k++) {
                    arr[k]++;
                }
            }
            
            int cnt = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] > 0) {
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}

class WorkTime {
    int start;
    int end;

    public WorkTime(int start, int end) {
        this.start = start;
        this.end = end;
    }
}