import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int code = sc.nextInt();
        Product p1 = new Product();
        Product p2 = new Product(name, code);

        System.out.println(p1);
        System.out.println(p2);
    }
}

class Product {
    String name;
    int code;

    public Product() {
        this.name = "codetree";
        this.code = 50;
    }

    public Product(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("product %d is %s", this.code, this.name);
    }
}