import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int k = sc.nextInt(); 
        int[] map = new int[101]; 
        int[] dat = new int[1000001]; 

        for (int i = 0; i < n; i++) {
            map[i] = sc.nextInt(); 
        }

        int answer = 0; 
        int answerNum = 0; 

        for (int i = 0; i < n; i++) {
            for (int j = i - k; j <= i + k; j++) {
                if (j < 0 || j >= n || i == j) continue; 
                if (map[i] == map[j]) {
                    dat[map[i]]++; 
                    if (answer < dat[map[i]]) {
                        answerNum = map[i];
                        answer = dat[map[i]];
                    }
                    break; 
                }
            }
        }

        System.out.println(answerNum); // 결과 출력
        sc.close();
    }
}
