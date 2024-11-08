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
        for(int i = 1; i <= 1000000; i *= 10) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            for(int j = 0; j < 10; j++) {
                list.add(new ArrayList<>());
            }

            for(int j = 0; j < n; j++) {
                int num = arr.get(j);
                int digit = (num / i) % 10; 
                // 여기서 넣을 때 정렬 해줘야 되지 않나?
                ArrayList<Integer> selected = list.get(digit);
                int index = -1;
                for(int k = 0; k < selected.size(); k++) {
                    if(selected.get(k) > num) {
                        index = k;
                        break;
                    }
                }

                if(index == -1) {
                    list.get(digit).add(num);
                } else {
                    list.get(digit).add(index, num);
                }
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