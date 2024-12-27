public class Main {
    public static void main(String[] args) {
        print(0);
    }

    public static void print(int i) {
        if(i >= 4) {
            return;
        }

        System.out.println("HelloWorld");
        print(i+1);
    }
}