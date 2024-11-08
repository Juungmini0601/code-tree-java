import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // 기수 정렬
        for(int i = 10; i <= 1000000; i *= 10) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            for(int j = 0; j < 10; j++) {
                list.add(new ArrayList<>());
            }

            for(int j = 0; j < n; j++) {
                int num = arr.get(j);
                int digit = num % i;
                // 여기서 넣을 때 정렬 해줘야 되지 않나?
                list.get(digit).add(num);
            }

            ArrayList<Integer> newList = new ArrayList<>();
            for(int j = 0; j < 10; j++) {
                int size = list.get(j).size();

                for(int k = 0; k < size; k++) {
                    Integer num = list.get(j).get(k);
                    newList.add(num);
                }
            }

            arr = newList;
        }

        // System.out.println(arr);
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}