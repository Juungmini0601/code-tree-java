import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Character> list = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();

        for(int i = 0; i < str.length(); i++) {
            list.addLast(str.charAt(i));
        }

        ListIterator<Character> it = list.listIterator(list.size());

        for(int i = 0; i < m; i++) {
            char c = sc.next().charAt(0);
            if(c == 'L') {
                if(it.hasPrevious()) {
                    it.previous();
                }
            } else if(c == 'R') {
                if(it.hasNext()) {
                    it.next();
                }
            } else if(c == 'D') {
                if(it.hasNext()) {
                    it.next();
                    it.remove();
                }
            } else {
                char newC = sc.next().charAt(0);
                it.add(newC);
            }
        }


        it = list.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next());
        }
        // System.out.println(list);
    }
}