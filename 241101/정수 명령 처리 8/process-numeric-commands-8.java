import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String cmd = sc.next();

            if(cmd.equals("push_front")) {
                int a = sc.nextInt();
                list.addFirst(a);
            } else if(cmd.equals("push_back")) {
                int a = sc.nextInt();
                list.addLast(a);
            } else if(cmd.equals("pop_front")) {
                int a = list.pollFirst();
                System.out.println(a);
            } else if(cmd.equals("pop_back")) {
                int a = list.pollLast();
                System.out.println(a);
            } else if(cmd.equals("size")) {
                System.out.println(list.size());
            } else if (cmd.equals("empty")) {
                System.out.println(list.isEmpty() ? 1 : 0);
            } else if(cmd.equals("front")) {
                System.out.println(list.peekFirst());
            } else {
                // back
                System.out.println(list.peekLast());
            }
        }
    }
}