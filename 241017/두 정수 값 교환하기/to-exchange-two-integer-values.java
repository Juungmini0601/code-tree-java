import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        IntWrapper a = new IntWrapper(sc.nextInt());
        IntWrapper b = new IntWrapper(sc.nextInt());
        swap(a, b);
        System.out.println(a.value + " " + b.value);
    }

    public static void swap(IntWrapper a, IntWrapper b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
}

class IntWrapper {
    int value;

    public IntWrapper (int value) {
        this.value = value;
    }
}