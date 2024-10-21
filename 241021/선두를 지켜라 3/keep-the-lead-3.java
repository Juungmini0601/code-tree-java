import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        //a의 움직입
        int[] locationA = new int[1000*n];
        int index = 1;
        int start = locationA[0];
        for(int i=0; i<n; i++){
            int velocity = sc.nextInt();
            int time = sc.nextInt();
            for(int j=1; j<=time; j++){
                start += velocity;
                locationA[index++] = start;
            }
        }
        //for(int i=0; i<locationA.length; i++) System.out.print(locationA[i]+" ");

        //b의 움직입
        int[] locationB = new int[1000*m];
        index = 1;
        start = locationB[0];
        for(int i=0; i<m; i++){
            int velocity = sc.nextInt();
            int time = sc.nextInt();
            for(int j=1; j<=time; j++){
                start += velocity;
                locationB[index++] = start;
            }
        }

        int cnt = 0;
        int idx = 1;
        int size = Math.min(locationA.length, locationB.length);
        while( idx<size ){
            if( locationA[idx] > locationB[idx] && locationA[idx-1] <= locationB[idx-1] ) cnt++;
            if( locationA[idx] < locationB[idx] && locationA[idx-1] >= locationB[idx-1] ) cnt++;
            if( locationA[idx] == locationB[idx] && locationA[idx-1] != locationB[idx-1] ) cnt++;
            idx++;
        }
        System.out.println(cnt-1);
    }
}