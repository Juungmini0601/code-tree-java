import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int lv = sc.nextInt();

        User u1 = new User();
        User u2 = new User(id, lv);
        System.out.println(u1);
        System.out.println(u2);
    }

    static class User {
        String id;
        int lv;

        public User() {
            this.id = "codetree";
            this.lv = 10;
        }

        public User(String id, int lv) {
            this.id = id;
            this.lv = lv;
        }

        @Override
        public String toString() {
            return "user " + this.id + " lv " + this.lv;
        }
    }
}