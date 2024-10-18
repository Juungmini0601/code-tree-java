import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        String point = sc.next();
        int time = sc.nextInt();

        Place p = new Place(code, point, time);

        System.out.println("secret code : " + p.code);
        System.out.println("meeting point : " + p.point);
        System.out.println("time : " + p.time);
    }
}

class Place {
    String code;
    String point;
    int time;

    public Place(String code, String point, int time) {
        this.code = code;
        this.point = point;
        this.time = time;
    }
}