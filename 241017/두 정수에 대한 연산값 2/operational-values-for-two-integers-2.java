import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerWrapper a = new IntegerWrapper(sc.nextInt());
        IntegerWrapper b = new IntegerWrapper(sc.nextInt());

        change(a, b);

        System.out.println(a.value + " " + b.value);
    }

    public static void change(IntegerWrapper a, IntegerWrapper b) {
        if(a.value > b.value) {
            a.value *= 2;
            b.value += 10;
        } else {
            a.value += 10;
            b.value *= 2;
        }
    }
}

class IntegerWrapper {
    int value;

    public IntegerWrapper(int value) {
        this.value = value;
    }
}