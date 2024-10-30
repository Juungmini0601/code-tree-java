import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String cmd = sc.next();

            if(cmd.equals("push_back")) {
                int num = sc.nextInt();
                list.add(num);
            } else if(cmd.equals("get")) {
                int num = sc.nextInt();
                System.out.println(list.get(num-1));
            } else if(cmd.equals("size")) {
                System.out.println(list.size());
            } else {
                // pop_back
                list.remove(list.size()-1);
            }
        }
    }
}