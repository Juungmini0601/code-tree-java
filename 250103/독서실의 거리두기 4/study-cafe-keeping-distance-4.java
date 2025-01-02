import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

import java.util.Arrays;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        char[] charArr = br.readLine().toCharArray();
        arr = new int[charArr.length];

        // char to int
        for(int i = 0; i < arr.length; i++) {
            arr[i] = charArr[i] - '0';
        }

        // 최소값들의 최대값
        int maxMin = 0;

        // 2개의 좌석을 선택한다.
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] == 1 || arr[j] == 1) {
                    continue;
                }

                arr[i] = 1;
                arr[j] = 1;

                // 현재 좌석 상태에서 거리의 최소값
                int min = distance();
                maxMin = Math.max(min, maxMin);

                arr[i] = 0;
                arr[j] = 0;
            }
        }

        System.out.println(maxMin);
    }

    public static int distance() {
        int distance = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] == 0 || arr[j] == 0) {
                    continue;
                }

                distance = Math.min(distance, Math.abs(i - j));
            }
        }

        return distance;
    }
}