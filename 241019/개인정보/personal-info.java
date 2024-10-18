import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5];

        for(int i = 0; i < 5; i++) {
            students[i] = new Student(sc.next(), sc.nextInt(), sc.nextDouble());
        }

        Arrays.sort(students, (a, b) -> a.name.compareTo(b.name));
        System.out.println("name");
        for(int i = 0; i < 5; i++) {
            System.out.println(students[i]);
        }
        System.out.println();

        Arrays.sort(students, (a, b) -> b.height - a.height);
        System.out.println("height");
        for(int i = 0; i < 5; i++) {
            System.out.println(students[i]);
        }
        System.out.println();
    }
}

class Student {
    String name;
    int height;
    double weight;

    public Student(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s %d %.1f", this.name, this.height, this.weight);
    }
}